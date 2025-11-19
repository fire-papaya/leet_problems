package medium

class WordDistance {
    fun minDistance(word1: String, word2: String): Int {
        return computeEditCost(word1, word2, word1.length, word2.length)
    }

    private fun computeEditCost(word1: String, word2: String, i: Int, j: Int): Int {
        val key = "${i}_${j}"
        if (i == 0)
            return j
        if (j == 0)
            return i

        if (solutionMap.containsKey(key))
            return solutionMap[key]!!

        if (word1[i - 1] == word2[j - 1]) {
            solutionMap[key] = computeEditCost(word1, word2, i-1, j-1)
        }
        else {
            val cost = 1 + minOf(
                computeEditCost(word1, word2, i-1, j), // deletion
                computeEditCost(word1, word2, i, j-1), // insertion
                computeEditCost(word1, word2, i-1, j-1) // replacement
            )

            solutionMap[key] = cost
        }

        return solutionMap[key]!!
    }

    private val solutionMap = hashMapOf<String, Int>()
}