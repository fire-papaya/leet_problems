package hard

import java.util.*
import kotlin.collections.ArrayList


class CriticalConnection {
    fun criticalConnections(n: Int, connections: List<List<Int>>): List<List<Int>> {
        val graph = Array<MutableList<Int>>(n) { mutableListOf() }

        for (oneConnection in connections) {
            graph[oneConnection[0]].add(oneConnection[1])
            graph[oneConnection[1]].add(oneConnection[0])
        }

        val connectionsSet = HashSet(connections)
        val rank = IntArray(n) { -2 }
        dfs(graph, 0, 0, rank, connectionsSet)
        return ArrayList(connectionsSet)
    }

    private fun dfs(
        graph: Array<MutableList<Int>>,
        node: Int,
        depth: Int,
        rank: IntArray,
        connectionsSet: HashSet<List<Int>>
    ): Int {
        if (rank[node] >= 0) {
            return rank[node] // already visited node. return its rank
        }
        rank[node] = depth
        var minDepthFound = depth // can be Integer.MAX_VALUE also.
        for (neighbor in graph[node]) {
            if (rank[neighbor] == depth - 1) { // ignore parent
                continue
            }
            val minDepth = dfs(graph, neighbor, depth + 1, rank, connectionsSet)
            minDepthFound = Math.min(minDepthFound, minDepth)
            if (minDepth <= depth) {
                // to avoid the sorting just try to remove both combinations. of (x,y) and (y,x)
                connectionsSet.remove(listOf(node, neighbor))
                connectionsSet.remove(listOf(neighbor, node))
            }
        }
        return minDepthFound
    }
}