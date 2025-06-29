package easy

class MyAtoi {
    val digits = "0123456789".toHashSet()

    fun myAtoi(s: String): Int {
        var result = 0L
        val str = s.trim()

        if (str.isBlank())
            return 0

        val positive = str[0] != '-'

        for (i in str.indices) {
            val c = str[i]
            if (digits.contains(c)) {
                result = result * 10 + (c.toInt() - 48)
            } else if (i == 0 && (c == '+' || c == '-'))
                continue
            else break

            if (result > Int.MAX_VALUE)
               return if (positive) Int.MAX_VALUE else Int.MIN_VALUE
        }

        if (!positive)
            result *= -1

        return result.toInt()
    }
}