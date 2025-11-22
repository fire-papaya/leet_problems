package hard

class DistinctSubsequences {
    fun numDistinct(s: String, t: String): Int {
        val memo = hashMapOf<Pair<Int, Int>, Int>()

        return countDistinct(s, t, 0, 0, memo)
    }

    private fun countDistinct(s: String, t: String, i: Int, k: Int, memo: HashMap<Pair<Int, Int>, Int>): Int {
        if (k == t.length) return 1
        if (i >= s.length) return 0

        val key = Pair(i, k)
        if (key in memo) return memo[key]!!

        var result = 0

        if (s[i] == t[k]) {
            result += countDistinct(s, t, i + 1, k + 1, memo)
        }
        result += countDistinct(s, t, i + 1, k, memo)

        memo[key] = result
        return result
    }
}