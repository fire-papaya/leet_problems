/** Author temur.navoi
 *  Created on 4/16/21 22:29
 */

package daily

import kotlin.math.min

class RemoveAdjacentDuplicates {
    fun removeDuplicates(s: String, k: Int): String {
        val letters = ArrayList<Char>()
        val sequenceCount = hashMapOf<Char, Int>()

        for (char in s) {
            if (letters.isEmpty()) {
                letters.add(char)
                sequenceCount[char] = 1
            }
            else if (letters.last() == char) {
                sequenceCount.compute(char) { _, count -> (count ?: 0) + 1 }

                if (sequenceCount[char] == k) {
                    // remove adjacent chars
                    for (i in 1 until k) {
                        letters.removeAt(letters.size - 1)
                    }

                    sequenceCount[char] = 0

                    if (letters.isNotEmpty()) {
                        sequenceCount[letters.last()] = 1
                    }

                    // update sequence counter
                    for (i in 1 until min(letters.size, k)) {

                        if (letters[letters.size - i] == letters[letters.size - i - 1]) {
                            val letter = letters[letters.size - i]
                            sequenceCount[letter] = sequenceCount[letter]!! + 1
                        } else {
                            break
                        }
                    }
                } else {
                    letters.add(char)
                }
            } else {
                sequenceCount[letters.last()] = 1
                sequenceCount[char] = 1
                letters.add(char)
            }
        }

        return letters.joinToString("")
    }
}