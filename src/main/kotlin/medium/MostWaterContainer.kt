package medium

import java.util.TreeMap


class MostWaterContainer {
    fun maxArea(height: IntArray): Int {
        var maxArea = 0
//        val heightsMap = HashMap<>()
//        val heightsSet = height.toHashSet()

        val set = hashSetOf<Int>()

        for (wall1 in 0 until height.size - 1) {
            if (set.contains(height[wall1]))
                continue

            val maxWidth = height.size - 1 - wall1

            if (height[wall1] < maxArea / maxWidth)
                continue

            for (wall2 in height.size - 1 downTo  wall1 + 1) {
                val wallHeight = kotlin.math.min(height[wall1], height[wall2])

                val tempArea = wallHeight * (wall2 - wall1)

                if (tempArea > maxArea)
                    maxArea = tempArea
            }

            set.add(height[wall1])
        }

        return maxArea
    }
}