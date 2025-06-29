package easy

class RomanToInteger {
    val symbolsValue = hashMapOf<Char, Int>(
    'I' to 1,
    'V' to 5,
    'X' to 10,
    'L' to 50,
    'C' to 100,
    'D' to 500,
    'M' to 1000
    )

    fun romanToInt(s: String): Int {
        var subtraction: Int = 0
        var sum: Int = 0

        for (i in 0 until s.length) {
            if(i + 1 < s.length && symbolsValue[s[i]]!! < symbolsValue[s[i+1]]!!)
                subtraction -= symbolsValue[s[i]]!!
            else
                sum += symbolsValue[s[i]]!!
        }

        return sum + subtraction
    }
}
