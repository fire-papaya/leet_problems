/** Author temur.navoi
 *  Created on 3/26/21 22:09
 */

package daily

class ArrayBaseSolution {
    fun wordSubsets(A: Array<String>, B: Array<String>): List<String> {
        val superSet = generateSuperSet(B)

        return A.filter { isUniversal(superSet, it) }
    }

    private fun isUniversal (superSet: HashMap<Char, Int>, word:String): Boolean {
        val hashedWord = hashWord(word)
        for (char in superSet.keys) {
            if (!hashedWord.containsKey(char) || hashedWord[char]!! < superSet[char]!!) {
                return false
            }
        }

        return true
    }

    private fun generateSuperSet (words: Array<String>) : HashMap<Char, Int> {
        val union = hashMapOf<Char, Int>()
        for (word in words) {
            val hashedWord = hashWord(word)

            for (char in hashedWord.keys) {
                if (!union.containsKey(char) || union[char]!! < hashedWord[char]!! ) {
                    union[char] = hashedWord[char]!!
                }
            }
        }

        return union
    }

    private fun hashWord (word: String) : HashMap<Char, Int> {
        val result = hashMapOf<Char, Int>()
        word.forEach {
            if (result.containsKey(it))
                result[it] = result[it]!! + 1
            else
                result[it] = 1
        }

        return result
    }
}