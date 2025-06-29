package medium

class CourseSchedule2 {
    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        val reqMap = prerequisites
            .groupBy({ it[0] }, { it[1] })

        val courses = (0 until numCourses).toList()
        val courseOrder = mutableListOf<Int>()

        try {
            dfsCheck(courses, reqMap, courseOrder, mutableSetOf<Int>(), mutableSetOf<Int>())
        } catch (e: RuntimeException) {
            if (e.message == "CYCLIC_REQUIREMENT")
                return intArrayOf()
        }

        return courseOrder.toIntArray()
    }

    fun dfsCheck(courses: List<Int>, reqs: Map<Int, List<Int>>, courseOrder: MutableList<Int>, addedCourses: MutableSet<Int>, visitedCourses: MutableSet<Int>) {
        for (course in courses) {
            if (visitedCourses.contains(course))
                throw RuntimeException("CYCLIC_REQUIREMENT")

            //println("Checking course $course")
            if (addedCourses.contains(course))
                continue

            if (reqs.containsKey(course)) {
                //println("Going into requirements of course $course: ${reqs[course]!!.joinToString()}")
                visitedCourses.add(course)
                dfsCheck(reqs[course]!!, reqs, courseOrder, addedCourses, visitedCourses)
                visitedCourses.remove(course)
            }

            courseOrder.add(course)
            addedCourses.add(course)

        }

    }
}