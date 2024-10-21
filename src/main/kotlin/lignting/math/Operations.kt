package lignting.math

operator fun Vector<out Number>.plus(other: Vector<Number>) =
    when (type) {
        Int::class.java -> Vector(size, values.mapIndexed { index, it ->
            it.toInt() + other.values[index].toInt()
        }, type)

        Byte::class.java -> Vector(size, values.mapIndexed { index, it ->
            it.toByte() + other.values[index].toByte()
        }, type)

        Short::class.java -> Vector(size, values.mapIndexed { index, it ->
            it.toShort() + other.values[index].toShort()
        }, type)

        Long::class.java -> Vector(size, values.mapIndexed { index, it ->
            it.toLong() + other.values[index].toLong()
        }, type)

        Float::class.java -> Vector(size, values.mapIndexed { index, it ->
            it.toFloat() + other.values[index].toFloat()
        }, type)

        Double::class.java -> Vector(size, values.mapIndexed { index, it ->
            it.toDouble() + other.values[index].toDouble()
        }, type)

        else -> throw RuntimeException("unsupported vector type")
    }

operator fun Vector<out Number>.plus(other: Number) =
    this + Vector(size, List(size) { other }, type)

operator fun Vector<out Number>.minus(other: Vector<Number>) =
    when (type) {
        Int::class.java -> Vector(size, values.mapIndexed { index, it ->
            it.toInt() - other.values[index].toInt()
        }, type)

        Byte::class.java -> Vector(size, values.mapIndexed { index, it ->
            it.toByte() - other.values[index].toByte()
        }, type)

        Short::class.java -> Vector(size, values.mapIndexed { index, it ->
            it.toShort() - other.values[index].toShort()
        }, type)

        Long::class.java -> Vector(size, values.mapIndexed { index, it ->
            it.toLong() - other.values[index].toLong()
        }, type)

        Float::class.java -> Vector(size, values.mapIndexed { index, it ->
            it.toFloat() - other.values[index].toFloat()
        }, type)

        Double::class.java -> Vector(size, values.mapIndexed { index, it ->
            it.toDouble() - other.values[index].toDouble()
        }, type)

        else -> throw RuntimeException("unsupported vector type")
    }

operator fun Vector<out Number>.minus(other: Number) =
    this + Vector(size, List(size) { other }, type)

operator fun Vector<out Number>.times(other: Vector<Number>) =
    when (type) {
        Int::class.java -> Vector(size, values.mapIndexed { index, it ->
            it.toInt() - other.values[index].toInt()
        }, type)

        Byte::class.java -> Vector(size, values.mapIndexed { index, it ->
            it.toByte() - other.values[index].toByte()
        }, type)

        Short::class.java -> Vector(size, values.mapIndexed { index, it ->
            it.toShort() - other.values[index].toShort()
        }, type)

        Long::class.java -> Vector(size, values.mapIndexed { index, it ->
            it.toLong() - other.values[index].toLong()
        }, type)

        Float::class.java -> Vector(size, values.mapIndexed { index, it ->
            it.toFloat() - other.values[index].toFloat()
        }, type)

        Double::class.java -> Vector(size, values.mapIndexed { index, it ->
            it.toDouble() - other.values[index].toDouble()
        }, type)

        else -> throw RuntimeException("unsupported vector type")
    }

operator fun Vector<out Number>.times(other: Number) =
    this + Vector(size, List(size) { other }, type)

operator fun Vector<out Number>.div(other: Vector<Number>) =
    when (type) {
        Int::class.java -> Vector(size, values.mapIndexed { index, it ->
            it.toInt() - other.values[index].toInt()
        }, type)

        Byte::class.java -> Vector(size, values.mapIndexed { index, it ->
            it.toByte() - other.values[index].toByte()
        }, type)

        Short::class.java -> Vector(size, values.mapIndexed { index, it ->
            it.toShort() - other.values[index].toShort()
        }, type)

        Long::class.java -> Vector(size, values.mapIndexed { index, it ->
            it.toLong() - other.values[index].toLong()
        }, type)

        Float::class.java -> Vector(size, values.mapIndexed { index, it ->
            it.toFloat() - other.values[index].toFloat()
        }, type)

        Double::class.java -> Vector(size, values.mapIndexed { index, it ->
            it.toDouble() - other.values[index].toDouble()
        }, type)

        else -> throw RuntimeException("unsupported vector type")
    }

operator fun Vector<out Number>.div(other: Number) =
    this + Vector(size, List(size) { other }, type)
