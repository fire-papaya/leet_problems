package daily

import java.util.*

class KeysAndRooms {
    fun canVisitAllRooms(rooms: List<List<Int>>): Boolean {
        val leftToVisit = rooms.indices.toHashSet()
        val keys: Queue<Int> = LinkedList<Int>()

        keys.offer(0)

        leftToVisit.remove(0)

        while (keys.isNotEmpty()) {
            val key = keys.poll()

            val newKeys = rooms[key]

            for (newKey in newKeys) {
                if (leftToVisit.contains(newKey)) {
                    keys.offer(newKey)
                    leftToVisit.remove(newKey)
                }
            }
        }

        return leftToVisit.isEmpty()
    }
}