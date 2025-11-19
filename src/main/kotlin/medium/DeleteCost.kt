package medium

class DeleteCost {
    fun minimumDeleteSum(s1: String, s2: String): Int {
        return computeDeleteCost(s1, s2, s1.length, s2.length)
    }

    fun computeDeleteCost(s1: String, s2: String, i: Int, j: Int) : Int {
        val key = "${i}_${j}"
        if (i == 0)
            return s2.substring(0, j).map{ it.code }.sum()
        if (j == 0)
            return s1.substring(0, i).map{ it.code }.sum()

        if (solutionMap.containsKey(key))
            return solutionMap[key]!!

        if (s1[i - 1] == s2[j - 1]) {
            val result = computeDeleteCost(s1, s2, i - 1, j - 1)
            solutionMap[key] = result
            return result
        }

        val cost = minOf(
            s1[i-1].code + computeDeleteCost(s1, s2, i - 1, j),
            s2[j-1].code + computeDeleteCost(s1, s2, i, j - 1)
        )
        solutionMap[key] = cost

        return cost
    }

    private val solutionMap = hashMapOf<String, Int>()
}