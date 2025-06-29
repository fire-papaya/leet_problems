/** Author temur.navoi
 *  Created on 4/17/21 17:05
 */

package daily

import kotlin.math.min

class SubmatrixSum {

    fun numSubmatrixSumTarget(matrix: Array<IntArray>, target: Int): Int {
        val sumMatrix = buildSumMatrix(matrix)
        val rows = matrix.size
        val columns = matrix[0].size
        var counter = 0

        for (rowSize in 1 .. rows) {
            for (colSize in 1 .. columns) {
                for (i in rowSize - 1 until rows) {
                    val rowDiff = i - rowSize
                    for (j in colSize - 1 until columns) {
                        val colDiff = j - colSize
                        val commonSumRow = min(rowDiff, i)
                        val commonSumCol = min(colDiff, j)

                        val subMatrixSum = sumMatrix[i][j] -
                                (if (rowDiff >= 0) sumMatrix[rowDiff][j] else 0) -
                                (if (colDiff >= 0) sumMatrix[i][colDiff] else 0) +
                                (if (commonSumRow >= 0 && commonSumCol >= 0) sumMatrix[commonSumRow][commonSumCol] else 0)

                        if (subMatrixSum == target)
                            counter++
                    }
                }
            }
        }

        return counter
    }

    fun buildSumMatrix (matrix: Array<IntArray>): Array<IntArray> {
        val rows = matrix.size
        val columns = matrix[0].size

        for (i in 1 until rows) {
            matrix[i][0] = matrix[i][0] + matrix[i-1][0]
        }

        for (j in 1 until columns) {
            matrix[0][j] = matrix[0][j] + matrix[0][j - 1]
        }

        for (i in 1 until rows) {
            for (j in 1 until columns) {
                matrix[i][j] = matrix[i][j] + matrix[i - 1][j] + matrix[i][j - 1] - matrix[i - 1][j - 1]
            }
        }

        return matrix
    }

}