package medium

class PhoneNumber {

    val keyboard = hashMapOf(
        Pair('2', "abc"),
        Pair('3', "def"),
        Pair('4', "ghi"),
        Pair('5', "jkl"),
        Pair('6', "mno"),
        Pair('7', "pqrs"),
        Pair('8', "tuv"),
        Pair('9', "wxyz")
    )

    fun letterCombinations(digits: String): List<String> {
        if (digits.isBlank())
            return emptyList()

        val filtered = digits.filter { keyboard.keys.contains(it) }
        if (filtered.length != digits.length)
            throw Exception("Digits contain wrong symbols")

        val sequences = mutableListOf<String>()
        iterate(digits, 0, "", sequences)

        return sequences
    }

    private fun iterate(digits: String, index: Int, sequence: String, sequences: MutableList<String>) {
        for (letter in keyboard[digits[index]]!!) {
            val concatenated = sequence.plus(letter)

            if (digits.length == concatenated.length)
                sequences.add(concatenated)
            else
                iterate(digits, index + 1, concatenated, sequences)
        }
    }
}