package medium

class ThreeSumClosest {
    fun threeSumClosest(nums: IntArray, target: Int): Int {
        nums.sort()
        var numI = Int.MAX_VALUE
        var sumIJ = Int.MAX_VALUE
        var sumIJK = Int.MAX_VALUE

        var result = Int.MAX_VALUE
        var delta = Int.MAX_VALUE

        for (i in 0 until nums.size - 2) {
            if (nums[i] == numI)
                continue

            numI = nums[i]

            for (j in i + 1 until nums.size - 1) {
                if (numI + nums[j] == sumIJ)
                    continue

                sumIJ = nums[i] + nums[j]

                var currDelta = Int.MAX_VALUE
                var currSum = Int.MAX_VALUE
                for (k in nums.size - 1 downTo j + 1) {
                    if (sumIJ + nums[k] == sumIJK)
                        continue

                    sumIJK = sumIJ + nums[k]
                    val diff = Math.abs(target - sumIJK)

                    if (diff == 0)
                        return sumIJK

                    if (diff < currDelta){
                        currDelta = diff
                        currSum = sumIJK
                    }
                    else {
                        break
                    }
                }

                if (currDelta < delta) {
                    result = currSum
                    delta = currDelta
                }
            }
        }

        return result
    }
}

fun main() {
    val solution = ThreeSumClosest()

    println(solution.threeSumClosest(intArrayOf(4,0,5,-5,3,3,0,-4,-5), -2))
}