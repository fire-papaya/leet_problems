package easy

class LngCommonPrefix {
    fun longestCommonPrefix(strs: Array<String>): String {
        var prefix = ""

        if (strs.size == 0)
            return prefix

        prefix = strs[0]

        for (i in 1 until strs.size) {
            var dropLast = 0
            val string = strs[i]

            if (string.length < prefix.length)
                prefix = prefix.dropLast(string.length - prefix.length)

            for (j in 0 until prefix.length) {
                if (!string[j].equals(prefix[j])){
                    dropLast = prefix.length - j
                    break
                }
            }

            prefix = prefix.dropLast(dropLast)

            if (prefix.length == 0)
                return ""
        }

        return prefix
    }
}