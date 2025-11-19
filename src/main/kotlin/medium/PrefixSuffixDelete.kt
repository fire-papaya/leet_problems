class PrefixSuffixDelete {
    fun minimumLength(s: String): Int {
        var str = s
        while (str.isNotEmpty()) {

            if (str.length == 1)
                return 1

            if (str.length == 2 && str[0] == str[1])
                return 0

            var headIndex = 0
            var tailIndex = s.length - 1

            val ch: Char = s[headIndex]

            if (str[tailIndex] == ch) {
                while (str[headIndex] == ch && headIndex + 1 < tailIndex) {headIndex++}
                while (str[tailIndex] == ch && headIndex + 1 < tailIndex) {tailIndex--}
                str = str.substring(headIndex, tailIndex + 1)
            } else {
                return str.length
            }


        }

        return 0
    }
}
