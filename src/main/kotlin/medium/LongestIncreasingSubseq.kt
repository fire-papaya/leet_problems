package medium

import kotlin.math.max

class LongestIncreasingSubseq {

    fun lengthOfLIS(nums: IntArray): Int {
        if (nums.isEmpty()) return 0

        val tails = IntArray(nums.size)
        var size = 0

        for (x in nums) {
            var i = 0
            var j = size

            // binary search for the position of x in tails
            while (i < j) {
                val m = (i + j) / 2
                if (tails[m] < x) i = m + 1 else j = m
            }

            tails[i] = x

            if (i == size) size++
        }

        return size
    }
}

