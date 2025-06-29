package medium

import kotlin.math.max

class ThreeSum {

    fun threeSum(nums: IntArray): List<List<Int>> {
        val valToIndexMap = hashMapOf<Int, MutableList<Int>>()
//        val triplets = hashSetOf<String>()

        nums.forEachIndexed { index, value ->
            if (valToIndexMap.contains(value))
                valToIndexMap[value]!!.add(index)
            else
                valToIndexMap[value] = mutableListOf(index)
        }

        val uniqueNumsArray = valToIndexMap.keys.sorted()
        val result = mutableListOf<List<Int>>()

        if (valToIndexMap.contains(0) && valToIndexMap[0]!!.size > 2)
            result.add(listOf(0,0,0))

        for (index1 in uniqueNumsArray.indices) {
            val num1 = uniqueNumsArray[index1]
            val num1TrueIndex = valToIndexMap.getValue(num1).first()
            val usedIndices = hashSetOf(num1TrueIndex)

            for (index2 in index1 until uniqueNumsArray.size) {
                val num2 = uniqueNumsArray[index2]

                if (num1 == 0 && num2 == 0)
                    continue

                val num2TrueIndex = valToIndexMap.getValue(num2)
                    .find { !usedIndices.contains(it) } ?: continue

                val num3 = - (num1 + num2)

                if (num3 > num2 && valToIndexMap.contains(num3)) {
                    usedIndices.add(num2TrueIndex)

                    valToIndexMap.getValue(num3)
                        .find { !usedIndices.contains(it) } ?: continue

                    val triplet = listOf(num3, num2, num1)

                    result.add(triplet)
                }

            }
        }

        return result
    }
}