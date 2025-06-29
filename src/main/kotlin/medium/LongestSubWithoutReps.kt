/** Author temur.navoi
 *  Created on 03/05/21 22:29
 */

package medium

import kotlin.math.max

class LongestSubWithoutReps {

    fun lengthOfLongestSubstring(s: String): Int {
        var maxSize = 0

        repeat(s.length) {
            val currentSet = hashSetOf<Char>()
            if (maxSize >= s.length - it) {
                return maxSize
            }

            for (char in s.substring(it)) {
                if (currentSet.contains(char)) break
                else {
                    currentSet.add(char)
                    maxSize = maxSize.coerceAtLeast(currentSet.size)
                }
            }
        }

        return maxSize
    }
}