package lignting.math

operator fun Vector<out Number>.plus(other: Vector<Number>) =
    when (type) {
        Int::class.java -> Vector(size, values.mapIndexed { index, it ->
            require(size == other.size)
            it.toInt() + other.values[index].toInt()
        }, type)

        Byte::class.java -> Vector(size, values.mapIndexed { index, it ->
            require(size == other.size)
            it.toByte() + other.values[index].toByte()
        }, type)

        Short::class.java -> Vector(size, values.mapIndexed { index, it ->
            require(size == other.size)
            it.toShort() + other.values[index].toShort()
        }, type)

        Long::class.java -> Vector(size, values.mapIndexed { index, it ->
            require(size == other.size)
            it.toLong() + other.values[index].toLong()
        }, type)

        Float::class.java -> Vector(size, values.mapIndexed { index, it ->
            require(size == other.size)
            it.toFloat() + other.values[index].toFloat()
        }, type)

        Double::class.java -> Vector(size, values.mapIndexed { index, it ->
            require(size == other.size)
            it.toDouble() + other.values[index].toDouble()
        }, type)

        else -> throw RuntimeException("unsupported vector type")
    }

operator fun Vector<out Number>.plus(other: Number) =
    this + Vector(size, List(size) { other }, type)

operator fun Matrix<out Number>.plus(other: Matrix<Number>) =
    when (type) {
        Int::class.java -> Matrix(shape, values.mapIndexed { a, it ->
            it.mapIndexed { b, it ->
                it.toInt() + other.values[a][b].toInt()
            }
        }, type)

        Byte::class.java -> Matrix(shape, values.mapIndexed { a, it ->
            it.mapIndexed { b, it ->
                it.toByte() + other.values[a][b].toByte()
            }
        }, type)

        Short::class.java -> Matrix(shape, values.mapIndexed { a, it ->
            it.mapIndexed { b, it ->
                it.toShort() + other.values[a][b].toShort()
            }
        }, type)

        Long::class.java -> Matrix(shape, values.mapIndexed { a, it ->
            it.mapIndexed { b, it ->
                it.toLong() + other.values[a][b].toLong()
            }
        }, type)

        Float::class.java -> Matrix(shape, values.mapIndexed { a, it ->
            it.mapIndexed { b, it ->
                it.toFloat() + other.values[a][b].toFloat()
            }
        }, type)

        Double::class.java -> Matrix(shape, values.mapIndexed { a, it ->
            it.mapIndexed { b, it ->
                it.toDouble() + other.values[a][b].toDouble()
            }
        }, type)

        else -> throw RuntimeException("unsupported vector type")
    }

operator fun Matrix<out Number>.plus(other: Vector<Number>) =
    this + Matrix(shape, (0..<shape.first).mapIndexed { index, _ ->
        (0..shape.second).map {
            other.values[index]
        }
    }, other.type).also {
        require(shape.second == other.size)
    }

operator fun Matrix<out Number>.plus(other: Number) =
    this + Matrix(shape, List(shape.first) { List(shape.second) { other } }, type)


operator fun Vector<out Number>.minus(other: Vector<Number>) =
    when (type) {
        Int::class.java -> Vector(size, values.mapIndexed { index, it ->
            require(size == other.size)
            it.toInt() - other.values[index].toInt()
        }, type)

        Byte::class.java -> Vector(size, values.mapIndexed { index, it ->
            require(size == other.size)
            it.toByte() - other.values[index].toByte()
        }, type)

        Short::class.java -> Vector(size, values.mapIndexed { index, it ->
            require(size == other.size)
            it.toShort() - other.values[index].toShort()
        }, type)

        Long::class.java -> Vector(size, values.mapIndexed { index, it ->
            require(size == other.size)
            it.toLong() - other.values[index].toLong()
        }, type)

        Float::class.java -> Vector(size, values.mapIndexed { index, it ->
            require(size == other.size)
            it.toFloat() - other.values[index].toFloat()
        }, type)

        Double::class.java -> Vector(size, values.mapIndexed { index, it ->
            require(size == other.size)
            it.toDouble() - other.values[index].toDouble()
        }, type)

        else -> throw RuntimeException("unsupported vector type")
    }

operator fun Vector<out Number>.minus(other: Number) =
    this + Vector(size, List(size) { other }, type)

operator fun Matrix<out Number>.minus(other: Matrix<Number>) =
    when (type) {
        Int::class.java -> Matrix(shape, values.mapIndexed { a, it ->
            it.mapIndexed { b, it ->
                it.toInt() - other.values[a][b].toInt()
            }
        }, type)

        Byte::class.java -> Matrix(shape, values.mapIndexed { a, it ->
            it.mapIndexed { b, it ->
                it.toByte() - other.values[a][b].toByte()
            }
        }, type)

        Short::class.java -> Matrix(shape, values.mapIndexed { a, it ->
            it.mapIndexed { b, it ->
                it.toShort() - other.values[a][b].toShort()
            }
        }, type)

        Long::class.java -> Matrix(shape, values.mapIndexed { a, it ->
            it.mapIndexed { b, it ->
                it.toLong() - other.values[a][b].toLong()
            }
        }, type)

        Float::class.java -> Matrix(shape, values.mapIndexed { a, it ->
            it.mapIndexed { b, it ->
                it.toFloat() - other.values[a][b].toFloat()
            }
        }, type)

        Double::class.java -> Matrix(shape, values.mapIndexed { a, it ->
            it.mapIndexed { b, it ->
                it.toDouble() - other.values[a][b].toDouble()
            }
        }, type)

        else -> throw RuntimeException("unsupported vector type")
    }

operator fun Matrix<out Number>.minus(other: Vector<Number>) =
    this + Matrix(shape, (0..<shape.first).mapIndexed { index, _ ->
        (0..shape.second).map {
            other.values[index]
        }
    }, other.type).also {
        require(shape.second == other.size)
    }

operator fun Matrix<out Number>.minus(other: Number) =
    this + Matrix(shape, List(shape.first) { List(shape.second) { other } }, type)

operator fun Vector<out Number>.times(other: Vector<Number>) =
    when (type) {
        Int::class.java -> Vector(size, values.mapIndexed { index, it ->
            require(size == other.size)
            it.toInt() * other.values[index].toInt()
        }, type)

        Byte::class.java -> Vector(size, values.mapIndexed { index, it ->
            require(size == other.size)
            it.toByte() * other.values[index].toByte()
        }, type)

        Short::class.java -> Vector(size, values.mapIndexed { index, it ->
            require(size == other.size)
            it.toShort() * other.values[index].toShort()
        }, type)

        Long::class.java -> Vector(size, values.mapIndexed { index, it ->
            require(size == other.size)
            it.toLong() * other.values[index].toLong()
        }, type)

        Float::class.java -> Vector(size, values.mapIndexed { index, it ->
            require(size == other.size)
            it.toFloat() * other.values[index].toFloat()
        }, type)

        Double::class.java -> Vector(size, values.mapIndexed { index, it ->
            require(size == other.size)
            it.toDouble() * other.values[index].toDouble()
        }, type)

        else -> throw RuntimeException("unsupported vector type")
    }

operator fun Vector<out Number>.times(other: Number) =
    this + Vector(size, List(size) { other }, type)

operator fun Matrix<out Number>.times(other: Matrix<Number>) =
    when (type) {
        Int::class.java -> Matrix(shape, values.mapIndexed { a, it ->
            it.mapIndexed { b, it ->
                it.toInt() * other.values[a][b].toInt()
            }
        }, type)

        Byte::class.java -> Matrix(shape, values.mapIndexed { a, it ->
            it.mapIndexed { b, it ->
                it.toByte() * other.values[a][b].toByte()
            }
        }, type)

        Short::class.java -> Matrix(shape, values.mapIndexed { a, it ->
            it.mapIndexed { b, it ->
                it.toShort() * other.values[a][b].toShort()
            }
        }, type)

        Long::class.java -> Matrix(shape, values.mapIndexed { a, it ->
            it.mapIndexed { b, it ->
                it.toLong() * other.values[a][b].toLong()
            }
        }, type)

        Float::class.java -> Matrix(shape, values.mapIndexed { a, it ->
            it.mapIndexed { b, it ->
                it.toFloat() * other.values[a][b].toFloat()
            }
        }, type)

        Double::class.java -> Matrix(shape, values.mapIndexed { a, it ->
            it.mapIndexed { b, it ->
                it.toDouble() * other.values[a][b].toDouble()
            }
        }, type)

        else -> throw RuntimeException("unsupported vector type")
    }

operator fun Matrix<out Number>.times(other: Vector<Number>) =
    this + Matrix(shape, (0..<shape.first).mapIndexed { index, _ ->
        (0..shape.second).map {
            other.values[index]
        }
    }, other.type).also {
        require(shape.second == other.size)
    }

operator fun Matrix<out Number>.times(other: Number) =
    this + Matrix(shape, List(shape.first) { List(shape.second) { other } }, type)

operator fun Vector<out Number>.div(other: Vector<Number>) =
    when (type) {
        Int::class.java -> Vector(size, values.mapIndexed { index, it ->
            require(size == other.size)
            it.toInt() / other.values[index].toInt()
        }, type)

        Byte::class.java -> Vector(size, values.mapIndexed { index, it ->
            require(size == other.size)
            it.toByte() / other.values[index].toByte()
        }, type)

        Short::class.java -> Vector(size, values.mapIndexed { index, it ->
            require(size == other.size)
            it.toShort() / other.values[index].toShort()
        }, type)

        Long::class.java -> Vector(size, values.mapIndexed { index, it ->
            require(size == other.size)
            it.toLong() / other.values[index].toLong()
        }, type)

        Float::class.java -> Vector(size, values.mapIndexed { index, it ->
            require(size == other.size)
            it.toFloat() / other.values[index].toFloat()
        }, type)

        Double::class.java -> Vector(size, values.mapIndexed { index, it ->
            require(size == other.size)
            it.toDouble() / other.values[index].toDouble()
        }, type)

        else -> throw RuntimeException("unsupported vector type")
    }

operator fun Vector<out Number>.div(other: Number) =
    this + Vector(size, List(size) { other }, type)

operator fun Matrix<out Number>.div(other: Matrix<Number>) =
    when (type) {
        Int::class.java -> Matrix(shape, values.mapIndexed { a, it ->
            it.mapIndexed { b, it ->
                it.toInt() / other.values[a][b].toInt()
            }
        }, type)

        Byte::class.java -> Matrix(shape, values.mapIndexed { a, it ->
            it.mapIndexed { b, it ->
                it.toByte() / other.values[a][b].toByte()
            }
        }, type)

        Short::class.java -> Matrix(shape, values.mapIndexed { a, it ->
            it.mapIndexed { b, it ->
                it.toShort() / other.values[a][b].toShort()
            }
        }, type)

        Long::class.java -> Matrix(shape, values.mapIndexed { a, it ->
            it.mapIndexed { b, it ->
                it.toLong() / other.values[a][b].toLong()
            }
        }, type)

        Float::class.java -> Matrix(shape, values.mapIndexed { a, it ->
            it.mapIndexed { b, it ->
                it.toFloat() / other.values[a][b].toFloat()
            }
        }, type)

        Double::class.java -> Matrix(shape, values.mapIndexed { a, it ->
            it.mapIndexed { b, it ->
                it.toDouble() / other.values[a][b].toDouble()
            }
        }, type)

        else -> throw RuntimeException("unsupported vector type")
    }

operator fun Matrix<out Number>.div(other: Vector<Number>) =
    this + Matrix(shape, (0..<shape.first).mapIndexed { index, _ ->
        (0..shape.second).map {
            other.values[index]
        }
    }, other.type).also {
        require(shape.second == other.size)
    }


operator fun Matrix<out Number>.div(other: Number) =
    this + Matrix(shape, List(shape.first) { List(shape.second) { other } }, type)

fun <E> Vector<E>.t(): ColumnVector<E> = ColumnVector(size, values, type)

fun <E> ColumnVector<E>.t(): Vector<E> = Vector(size, values, type)

fun Matrix<*>.T() = Matrix(
    shape.second to shape.first,
    (0..<shape.second).map { first ->
        (0..<shape.first).map { second ->
            values[first][second]
        }
    }, type
)

infix fun Vector<out Number>.dot(other: ColumnVector<out Number>): Number {
    require(size == other.size)
    return when (type) {
        Int::class.java -> values.zip(other.values).let {
            var count = 0
            it.forEach {
                count += (it.first.toInt() * it.second.toInt())
            }
            count
        }

        Byte::class.java -> values.zip(other.values).let {
            var count = 0
            it.forEach {
                count += (it.first.toByte() * it.second.toByte())
            }
            count.toByte()
        }

        Short::class.java -> values.zip(other.values).let {
            var count = 0
            it.forEach {
                count += (it.first.toShort() * it.second.toShort())
            }
            count.toShort()
        }

        Long::class.java -> values.zip(other.values).let {
            var count = 0L
            it.forEach {
                count += (it.first.toLong() * it.second.toLong())
            }
            count
        }

        Float::class.java -> values.zip(other.values).let {
            var count = 0.0f
            it.forEach {
                count += (it.first.toFloat() * it.second.toFloat())
            }
            count
        }

        Double::class.java -> values.zip(other.values).let {
            var count = 0.0
            it.forEach {
                count += (it.first.toDouble() * it.second.toDouble())
            }
            count
        }

        else -> throw RuntimeException("unsupported vector type")
    }

}

infix fun ColumnVector<out Number>.dot(other: Vector<out Number>) =
    when (type) {
        Int::class.java -> Matrix(
            size to other.size,
            values.map { first ->
                other.values.map { second ->
                    first.toInt() * second.toInt()
                }
            },
            type
        )

        Byte::class.java -> Matrix(
            size to other.size,
            values.map { first ->
                other.values.map { second ->
                    first.toByte() * second.toByte()
                }
            },
            type
        )

        Short::class.java -> Matrix(
            size to other.size,
            values.map { first ->
                other.values.map { second ->
                    first.toShort() * second.toShort()
                }
            },
            type
        )

        Long::class.java -> Matrix(
            size to other.size,
            values.map { first ->
                other.values.map { second ->
                    first.toLong() * second.toLong()
                }
            },
            type
        )

        Float::class.java -> Matrix(
            size to other.size,
            values.map { first ->
                other.values.map { second ->
                    first.toFloat() * second.toFloat()
                }
            },
            type
        )

        Double::class.java -> Matrix(
            size to other.size,
            values.map { first ->
                other.values.map { second ->
                    first.toDouble() * second.toDouble()
                }
            },
            type
        )

        else -> throw RuntimeException("unsupported vector type")
    }

fun Vector<out Number>.forms() =
    this dot this.t()

infix fun Vector<out Number>.distance(vector: Vector<out Number>) =
    this dot vector.t()

infix fun Matrix<out Number>.dot(other: Matrix<out Number>) =
    Matrix(
        shape.first to other.shape.second,
        this.vectors().map {a->
            other.columnVectors().map{b->
                a dot b
            }
        },
        type
    )