package medium

class MyPower() {
    fun myPow(x: Double, n: Int): Double {
        if (n == 0)
            return 1.0
        else if (x == 0.0)
            return 0.0

        var base = x
        val exp = n.toLong()      // prevent overflow when negating MIN_VALUE
        var result = 1.0

        var absExp = kotlin.math.abs(exp)

        while (absExp > 0)  {
            if ((absExp and 1L) == 1L) {
                result *= base
            }

            base *= base
            absExp = absExp shr 1
        }

        return if (exp < 0) 1.0 / result else result
    }
}

fun main() {
    println(MyPower().myPow(2.0, -2147483648))
}