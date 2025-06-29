/** Author temur.navoi
 *  Created on 4/12/21 21:49
 */

package daily

import java.util.*
import kotlin.collections.HashSet
import kotlin.math.abs

class Permutations (val n: Int, val k: Int) {
    val list: List<Int> = (1 .. n).toList()

    fun getPermutation (): List<Int> {
        val indicesSet = hashSetOf<Int>()
        val current = Stack<Int>()
        val permutations = mutableListOf<List<Int>>()

        permute(permutations, current, indicesSet, 0, list)

        return if (permutations.isNotEmpty()) permutations[0] else emptyList()
    }

    private fun permute (
        permutations: MutableList<List<Int>>,
        current: Stack<Int>,
        indices: HashSet<Int>,
        index: Int,
        elements: List<Int>
    ) {
        if (current.size >= elements.size) {
            if (checkK (current))
                permutations.add(current.toList())
            return
        }

        for (i in elements.indices) {
            val derivedIndex = (index + i) % elements.size

            if (!indices.contains(derivedIndex)) {
                current.push(elements[derivedIndex])
                indices.add(derivedIndex)

                val nextIndex = (derivedIndex + 1) % elements.size
                permute(permutations, current, indices, nextIndex, elements)

                if (permutations.isNotEmpty())
                    break

                indices.remove(derivedIndex)
                current.pop()
            }
        }
    }

    private fun checkK (list: List<Int>) : Boolean {
        val differenceNumber = hashSetOf<Int>()
        for (i in 0 until list.size - 1) {
            val difference = abs(list[i] - list[i + 1])

            if (!differenceNumber.contains(difference) && differenceNumber.size >= k) {
                return false
            }

            differenceNumber.add(difference)
        }

        return differenceNumber.size == k
    }
}

class BeautifulArrangement {
    fun constructArray(n: Int, k: Int): IntArray {
        val permutator = Permutations(n, k)
        return permutator.getPermutation().toIntArray()
    }
}