package hard

class MedianTwoArrays {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        if (nums1.isEmpty() && nums2.isEmpty())
            return 0.toDouble()

        val totalSize = nums1.size + nums2.size
        val isEvenSized = totalSize % 2 == 0
        val medianIndex = totalSize / 2

        var traversedNums = 0
        var median1 = 0
        var median2 = 0

        var nums1Index = 0
        var nums2Index = 0

        var nums1Finished = nums1Index >= nums1.size
        var nums2Finished = nums2Index >= nums2.size

        while (traversedNums <= medianIndex) {
            if (nums2Finished || (nums1Finished.not() && nums1[nums1Index] < nums2[nums2Index])) {
                if ((traversedNums + 1) == medianIndex && isEvenSized) {
                    median2 = nums1[nums1Index]
                } else if (traversedNums == medianIndex) {
                    median1 = nums1[nums1Index]
                }
                nums1Index++
                nums1Finished = nums1Index >= nums1.size
            } else {
                if ((traversedNums + 1) == medianIndex && isEvenSized) {
                    median2 = nums2[nums2Index]
                } else if (traversedNums == medianIndex) {
                    median1 = nums2[nums2Index]
                }

                nums2Index++
                nums2Finished = nums2Index >= nums2.size
            }

            traversedNums++
        }

        return if (isEvenSized) {
            (median1.toDouble() + median2.toDouble())/2
        } else {
            median1.toDouble()
        }
    }
}