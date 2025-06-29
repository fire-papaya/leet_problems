package medium

class IntToRoman {
    fun intToRoman(num: Int): String {
        if (num > 3999)
            throw IllegalArgumentException("Number has to be less than 4000")

        val units = arrayOf(
            'I', 'X', 'C', 'M'
        )

        val subtractionBase = arrayOf(
            arrayOf('V', 'X'),
            arrayOf('L', 'C'),
            arrayOf('D', 'M'),
            arrayOf('_', '_')
        )

        val roman = StringBuilder()
        var temp = num

        for (order in 0 .. 3) {
            val nextNum = temp % 10
            temp /= 10

            if (nextNum == 0)
                continue

            val mod5 = nextNum % 5

            if (mod5 == 4) {
                /* 4 or 9 */
                roman.append(subtractionBase[order][nextNum / 5]).append(units[order])
            } else {
                if (mod5 != 0) {
                    for (i in 1..mod5) {
                        roman.append(units[order])
                    }
                }

                if (nextNum >= 5) roman.append(subtractionBase[order][0])
            }

        }

        return roman.reverse().toString()

    }
}