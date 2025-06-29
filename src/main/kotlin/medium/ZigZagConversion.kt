/** Author temur.navoi
 *  Created on 04/07/21 21:11
 */

package medium

class ZigZagConversion {
    fun convert(s: String, numRows: Int): String {
        if (numRows == 1)
            return s

        val blocksNumber = calculateBlocksNumber(s, numRows)
        val matrix = initMatrix(blocksNumber, numRows)
        var stringIndex = 0
        for (i in 0 .. blocksNumber * (numRows - 1) step numRows - 1) {
            if (stringIndex == s.length)
                break

            for (k in 0 until numRows) {
                if (stringIndex == s.length)
                    break
                matrix[k][i] = s[stringIndex]
                stringIndex++
            }

            for (k in numRows - 2 downTo 1) {
                if (stringIndex == s.length)
                    break
                val delta = (numRows - 1 - k)
                matrix[k][i+delta] = s[stringIndex]
                stringIndex++
            }
        }

        return matrix.asSequence()
            .flatMap {
                it.asSequence()
                    .filter { ch -> ch != '\u0000' } }
            .joinToString("")
    }

    private fun calculateBlocksNumber (s: String, numRows: Int): Int {
        return s.length / (2 * numRows - 2) + if (s.length % (2 * numRows - 2) > 0) 1 else 0
    }

    private fun initMatrix(blocksNumber: Int, blockSize: Int): Array<CharArray> {
        return Array(blockSize) { CharArray(blocksNumber * (blockSize - 1)) }
    }
}