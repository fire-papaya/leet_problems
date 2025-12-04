package hard

class MaxRunTimeComputers {
    fun maxRunTime(n: Int, batteries: IntArray): Long {

        var low = 0.toLong()
        var high = batteries.sumOf { it.toLong() } / n.toLong()
        while (low < high) {
            val middle = (low + high + 1) / 2

            if (checkPossibleRuntime(batteries, middle, n)) {
                low = middle
            } else {
                high = middle - 1
            }
        }

        return low
    }

    fun checkPossibleRuntime(batteries: IntArray, runtime: Long, computerNum: Int): Boolean {
        val possibleRuntime = batteries.sumOf { minOf(it.toLong(), runtime) }

        return possibleRuntime >= runtime * computerNum
    }
}