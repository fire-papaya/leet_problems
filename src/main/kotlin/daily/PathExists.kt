package daily

class PathExists {
    fun validPath(n: Int, edges: Array<IntArray>, source: Int, destination: Int): Boolean {
        if (source == destination)
            return true

        val graph = formGraph(n, edges)

        return bfsFind(graph, hashSetOf(), source, destination)
    }

    private fun formGraph(n: Int, edges: Array<IntArray>): Array<HashSet<Int>> {
        val graph = Array(n) { hashSetOf<Int>() }

        for (edge in edges) {
            graph[edge[0]].add(edge[1])
            graph[edge[1]].add(edge[0])
        }

        return graph
    }

    private fun bfsFind(graph: Array<HashSet<Int>>, visited: HashSet<Int>, source: Int, destination: Int): Boolean {
        visited.add(source)
        if (graph[source].contains(destination))
            return true

        for (neighbour in graph[source]) {
            if (visited.contains(neighbour))
                continue

            visited.add(neighbour)

            if(bfsFind(graph, visited, neighbour, destination))
                return true
        }

        return false
    }
}