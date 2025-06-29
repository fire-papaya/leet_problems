package daily

class ValidParenthesisString {

    fun checkValidString(s: String): Boolean {
        var minOpen = 0
        var maxOpen = 0

        for (char in s) {
            when (char) {
                '(' -> {
                    minOpen += 1
                    maxOpen += 1
                }
                ')' -> {
                    minOpen -= 1
                    maxOpen -= 1
                }
                '*' -> {
                    minOpen -= 1
                    maxOpen += 1
                }
                else -> {
                    return false
                }
            }

            if (minOpen < 0) minOpen = 0

            if (maxOpen < 0) return false
        }

        return minOpen == 0
    }

}