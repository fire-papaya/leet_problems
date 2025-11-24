package medium

import kotlin.math.max

class LISNumber {
    fun findNumberOfLIS(nums: IntArray): Int {
        val n = nums.size
        if (n == 0) return 0

        val length = IntArray(n) { 1 }
        val count  = IntArray(n) { 1 }

        var maxLen = 1

        for (i in 0 until n) {
            for (j in 0 until i) {
                if (nums[j] < nums[i]) {
                    if (length[j] + 1 > length[i]) {
                        length[i] = length[j] + 1
                        count[i] = count[j]
                    }
                    else if (length[j] + 1 == length[i]) {
                        count[i] += count[j]
                    }
                }
            }
            maxLen = max(maxLen, length[i])
        }

        var ans = 0
        for (i in 0 until n) {
            if (length[i] == maxLen) ans += count[i]
        }

        return ans
    }
}