/** Author temur.navoi
 *  Created on 4/21/21 19:51
 */

package daily

import java.util.*
import kotlin.collections.ArrayList

class TriangleTraverser {
    var bestSum: Int = Int.MAX_VALUE
    var currentSum: Int = 0
}

class Triangle {
    fun minimumTotal(triangle: List<List<Int>>): Int {
        if (triangle.isEmpty())
            return 0

        if (triangle.size == 1)
            return triangle[0][0]

        val traverser = TriangleTraverser().apply { currentSum = triangle[0][0] }

        iterate(triangle, 1, 0, traverser)

        return traverser.bestSum
    }

    private fun iterate (triangle: List<List<Int>>, depth: Int, parentIndex: Int, traverser: TriangleTraverser) {
        for (childIndex in parentIndex .. parentIndex + 1) {
            val child = triangle[depth][childIndex]
            if (depth + 1 == triangle.size) {
                if (traverser.currentSum + child >= traverser.bestSum) {
                    continue
                } else {
                    traverser.bestSum = traverser.currentSum + child
                }
            } else {
                traverser.currentSum += child
                iterate(triangle, depth + 1, childIndex, traverser)
                traverser.currentSum -= child
            }
        }
    }
}