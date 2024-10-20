package lignting.math

/**
 * 向量
 * @author lignting
 * @date 2024-10-19
 * @constructor 创建[Vector]
 * @param [size] 大小
 * @param [values] 值
 */
data class Vector<T>(
    val size: Int,
    val values: List<T>,
    val type: Class<out Any>
)

/**
 * 大小
 */
fun Vector<*>.shape() = size

/**
 * 类型
 */
fun Vector<*>.type() = type

/**
 * 打印，并且把原来的值返回
 */
fun Vector<*>.print() = this.also(::println)

/**
 * 向量
 * @param [values] 值
 */
fun <T> vectorOf(vararg values: T) = Vector(values.size, values.toList(), values[0]!!::class.java)

/**
 * 向量
 * @param [values] 值
 */
fun <T> vectorOf(values: List<T>) = Vector(values.size, values, values[0]!!::class.java)

/**
 * 为向量
 */
fun <T> List<T>.toVector() = Vector(size, this, this[0]!!::class.java)

/**
 * 向量
 * @param [shape] 形状
 * @param [function] 函数
 */
fun Vector(shape: Int, function: (Int) -> Number) = Vector(shape, List(shape, function), Number::class.java)

/**
 * 转换成`Byte`
 */
fun Vector<out Number>.asByte() = Vector(size, values.map { it.toByte() }, Byte::class.java)

/**
 * 转换成`Short`
 */
fun Vector<out Number>.asShort() = Vector(size, values.map { it.toShort() }, Short::class.java)

/**
 * 转换成`Int`
 */
fun Vector<out Number>.asInt() = Vector(size, values.map { it.toInt() }, Int::class.java)

/**
 * 转换成`Long`
 */
fun Vector<out Number>.asLong() = Vector(size, values.map { it.toLong() }, Long::class.java)

/**
 * 转换成`Float`
 */
fun Vector<out Number>.asFloat() = Vector(size, values.map { it.toFloat() }, Float::class.java)

/**
 * 转换成`Double`
 */
fun Vector<out Number>.asDouble() = Vector(size, values.map { it.toDouble() }, Double::class.java)

/**
 * 重塑长度
 * @param [newSize] 新尺寸
 */
fun <T> Vector<T>.reshape(
    newSize: Int
) = Vector(newSize,
    if (newSize > size)
        values + List(newSize - size) { nan }
    else
        values.subList(0, newSize),
    type
)

/**
 * 矩阵
 * @author lignting
 * @date 2024-10-19
 * @constructor 创建[Matrix]
 * @param [shape] 形状
 * @param [values] 值
 */
data class Matrix<T>(
    val shape: Pair<Int, Int>,
    val values: List<List<T>>,
    val type: Class<out Any>
)

/**
 * 形状
 */
fun Matrix<*>.shape() = shape

/**
 * 类型
 */
fun Matrix<*>.type() = type

/**
 * 打印
 */
fun Matrix<*>.print() = this.also(::println)

/**
 * 大小
 */
fun Matrix<*>.size() = shape.first * shape.second

/**
 * 向量转换成矩阵
 */
fun Vector<out Any>.toMatrix() = Matrix(1 to size, listOf(values), type)

/**
 * 矩阵
 * @param [vectors] 向量
 */
fun <T> matrixOf(vararg vectors: Vector<T>) =
    Matrix(vectors.size to vectors[0].size, vectors.map { it.reshape(vectors[0].size).values }, vectors[0].type)

/**
 * 对矩阵
 */
fun <T> List<Vector<T>>.toMatrix() =
    Matrix(this.size to this[0].size, this.map { it.reshape(this[0].size).values }, this[0].type)


private fun <T> List<T>.reshape(
    newSize: Int
) = if (newSize > size)
    this + List(newSize - size) { nan }
else
    this.subList(0, newSize)

/**
 * 矩阵
 * @param [vectors] 向量
 */
fun <T> matrixOf(vararg vectors: List<T>) =
    Matrix(
        vectors.size to vectors[0].size,
        vectors.map { it.reshape(vectors[0].size) },
        vectors[0][0]!!::class.java
    )


/**
 * 对矩阵
 */
fun <T> List<List<T>>.toMatrixByList() =
    Matrix(
        size to this[0].size,
        this.map { it.reshape(this[0].size) },
        this[0][0]!!::class.java
    )


/**
 * 矩阵
 * @param [shape] 形状
 * @param [function] 函数
 */
fun Matrix(shape: Pair<Int, Int>, function: (Pair<Int, Int>) -> Number) = Matrix(shape, List(shape.first) { first ->
    List(shape.second) { second ->
        function(first to second)
    }
}, Number::class.java)


/**
 * 重塑
 * @param [newSizes] 新尺寸
 */
fun <T> Matrix<T>.reshape(newSizes: Pair<Int, Int>) = Matrix(
    newSizes,
    List(newSizes.first) {
        values.flatten()
            .reshape(newSizes.first * newSizes.second)
            .slice(it * newSizes.second until (it + 1) * newSizes.second)
    },
    type
)