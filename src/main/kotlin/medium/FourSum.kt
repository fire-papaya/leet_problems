package medium

class FourSum {
    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
        nums.sort()
        var sumAB: Long
        var sumABC: Long
        var sumABCD: Long
        val targetLong = target.toLong()

        val result = mutableListOf<List<Int>>()

        for (a in 0 until nums.size - 3) {
            if (a > 0 && nums[a] == nums[a - 1])
                continue

            for (b in a + 1 until nums.size - 2) {
                if (b > a + 1 && nums[b] == nums[b - 1])
                    continue

                sumAB = nums[a].toLong() + nums[b].toLong()

                for (c in b + 1 until nums.size - 1) {
                    if (c > b + 1 && nums[c] == nums[c - 1])
                        continue

                    sumABC = sumAB + nums[c].toLong()

                    for (d in nums.size - 1 downTo c + 1) {
                        if (d < nums.size - 1 && nums[d] == nums[d + 1])
                            continue

                        sumABCD = sumABC + nums[d].toLong()

                        if (sumABCD < targetLong)
                            break

                        if (sumABCD == targetLong) {
                            result.add(listOf(nums[a], nums[b], nums[c], nums[d]))
                        }
                    }
                }
            }
        }

        return result
    }
}

fun main() {
    val solution = FourSum()

    println(solution.fourSum(intArrayOf(1000000000,1000000000,1000000000,1000000000), -294967296))
    println(solution.fourSum(intArrayOf(1,0,-1,0,-2,2), 0))
}