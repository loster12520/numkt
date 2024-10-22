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
    this + Matrix(shape, (0..<shape.first).mapIndexed {index, _ ->
        (0 .. shape.second).map {
            other.values[index]
        }
    }, other.type).also {
        require(shape.second == other.size)
    }

operator fun Matrix<out Number>.plus(other: Number) =
    this + Matrix(shape, List(shape.first){List(shape.second){other} }, type)


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
    this + Matrix(shape, (0..<shape.first).mapIndexed {index, _ ->
        (0 .. shape.second).map {
            other.values[index]
        }
    }, other.type).also {
        require(shape.second == other.size)
    }

operator fun Matrix<out Number>.minus(other: Number) =
    this + Matrix(shape, List(shape.first){List(shape.second){other} }, type)

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
    this + Matrix(shape, (0..<shape.first).mapIndexed {index, _ ->
        (0 .. shape.second).map {
            other.values[index]
        }
    }, other.type).also {
        require(shape.second == other.size)
    }

operator fun Matrix<out Number>.times(other: Number) =
    this + Matrix(shape, List(shape.first){List(shape.second){other} }, type)

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
    this + Matrix(shape, (0..<shape.first).mapIndexed {index, _ ->
        (0 .. shape.second).map {
            other.values[index]
        }
    }, other.type).also {
        require(shape.second == other.size)
    }


operator fun Matrix<out Number>.div(other: Number) =
    this + Matrix(shape, List(shape.first){List(shape.second){other} }, type)

fun Vector<*>.T() = ColumnVector(size, values, type)

fun ColumnVector<*>.T() = Vector(size, values, type)

fun Matrix<*>.T() = Matrix(
    shape.second to shape.first,
    (0..<shape.second).map { first ->
        (0..<shape.first).map { second ->
            values[first][second]
        }
    }, type
)

//infix fun Vector<out Number>.dot(other: ColumnVector<Number>): Number {
//    require(size == other.size)
//    return when (type) {
//        Int::class.java -> (0..<size).reduce { a, index ->
//            a + (values[index].toInt() * other.values[index].toInt())
//        }
//
//        Byte::class.java -> (0..<size).reduce { a, index ->
//            a + (values[index].toByte() * other.values[index].toByte())
//        }
//
//        Short::class.java -> (0..<size).reduce { a, index ->
//            a + (values[index].toShort() * other.values[index].toShort())
//        }
//
//        Long::class.java -> values.zip(other.values).reduce { a: Number, it ->
//            a.toLong() + (it.first.toLong() * it.second.toLong())
//        }
//
//        Float::class.java -> (0..<size).reduce { a, index ->
//            a + (values[index].toInt() * other.values[index].toInt())
//        }
//
//        Double::class.java -> (0..<size).reduce { a, index ->
//            a + (values[index].toInt() * other.values[index].toInt())
//        }
//
//        else -> throw RuntimeException("unsupported vector type")
//    }
//
//}