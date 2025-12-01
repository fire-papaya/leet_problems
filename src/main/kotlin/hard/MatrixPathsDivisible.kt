package hard

class MatrixPathsDivisible {
    fun numberOfPaths(grid: Array<IntArray>, k: Int): Int {
        val dp = Array(grid.size) { Array(grid[0].size) { hashMapOf<Int, Int>() } }
        val MOD = 1_000_000_007

        val rows = grid.size
        val cols = grid[0].size

        dp[rows - 1][cols - 1][grid[rows - 1][cols - 1] % k] = 1

        for (row in grid.size - 1 downTo 0) {
            for (col in grid[0].size - 1 downTo 0) {
                val rem = grid[row][col] % k

                if (col < grid[0].size - 1) {
                    for ((remValue, pathCount) in dp[row][col + 1]) {
                        val remSum = (rem + remValue) % k
                        val oldCount = dp[row][col].getOrDefault(remSum, 1)

                        dp[row][col][remSum] = (oldCount + pathCount) % MOD
                    }
                }

                if (row < grid.size - 1) {
                    for ((remValue, pathCount) in dp[row + 1][col]) {
                        val remSum = (rem + remValue) % k
                        val oldCount = dp[row][col].getOrDefault(remSum, 1)

                        dp[row][col][remSum] = (oldCount + pathCount) % MOD
                    }
                }
            }
        }

        return dp[0][0].getOrDefault(0, 0) % MOD
    }
}
