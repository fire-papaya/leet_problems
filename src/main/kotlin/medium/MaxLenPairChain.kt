package medium


class MaxLenPairChain {
    fun findLongestChain(pairs: Array<IntArray>): Int {
        var maxLen = 1
        val n = pairs.size

        val dp = IntArray(n) { 1 }

        for (i in 0 until n) {
            for (j in 0 until i) {
                if (pairs[j][1] < pairs[i][0]) {
                    dp[i] = maxOf(dp[i], 1 + dp[j])
                }
            }

            maxLen = maxOf(maxLen, dp[i])
        }

        return maxLen
    }
}