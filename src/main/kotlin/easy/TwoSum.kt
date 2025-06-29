/** Author temur.navoi
 *  Created on 03/05/21 21:20
 */

package easy

class TwoSum {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = hashMapOf<Int, Int>()
        for (index in nums.indices) {
            map[nums[index]] = index
        }

        for (index in nums.indices) {
            if (map.containsKey(target - nums[index]) && map[target - nums[index]]!! != index) {
                return intArrayOf(index, map[target - nums[index]]!!)
            }
        }

        return intArrayOf()
    }
}