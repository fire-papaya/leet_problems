/** Author temur.navoi
 *  Created on 30/06/21 23:16
 */

package medium

class LongestPalindrome {
    fun longestPalindrome(s: String): String {
        var longest = ""

        for (startIndex in s.indices) {
            var endIndex = s.lastIndex

            if (endIndex - startIndex + 1 <= longest.length)
                return longest

            do {
                if (s[startIndex] == s[endIndex]) {
                    var movingStart = startIndex
                    var movingEnd = endIndex

                    while (movingStart < movingEnd) {
                        movingStart++
                        movingEnd--

                        if (s[movingStart] != s[movingEnd]) {
                            break
                        }
                    }

                    if (movingStart >= movingEnd && longest.length < endIndex - startIndex + 1) {
                        longest = s.substring(startIndex .. endIndex)
                    }
                }

                endIndex--
            } while (startIndex < endIndex && endIndex - startIndex + 1 > longest.length)
        }


        return longest
    }
}