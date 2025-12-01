package easy

import java.lang.Integer.min
import kotlin.math.max

class BinPrefixDiv5 {
    fun prefixesDivBy5(nums: IntArray): List<Boolean> {
        val result = mutableListOf<Boolean>()
        var currentNum = 0

        nums.forEach {
            currentNum = (currentNum * 2 + it) % 5
            result.add(currentNum == 0)
        }

        return result
    }
}