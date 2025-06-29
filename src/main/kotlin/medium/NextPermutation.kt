package medium

class NextPermutation {
    fun nextPermutation(nums: IntArray): Unit {


        if (nums.size == 1)
            return

        for (index in nums.size - 2 downTo 0) {
            if (nums[index] < nums[index + 1]) {
                var swapIndex = nums.size - 1
                while (nums[swapIndex] <= nums[index] && swapIndex > index + 1) {
                    swapIndex--
                }

                val dummy = nums[index]
                nums[index] = nums[swapIndex]
                nums[swapIndex] = dummy

                rotateSlice(index + 1, nums.size - 1, nums)
                return
            }
        }

        rotateSlice(0, nums.size - 1, nums)
    }

    fun rotateSlice (from: Int, to: Int, nums: IntArray): Unit {
        var startIndex = from
        var endIndex = to
        while (startIndex < endIndex) {
            val dummy = nums[startIndex]
            nums[startIndex] = nums[endIndex]
            nums[endIndex] = dummy

            startIndex++
            endIndex--
        }
    }
}