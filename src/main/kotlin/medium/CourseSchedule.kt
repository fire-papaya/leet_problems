package medium

class CourseSchedule {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val prereqs = prerequisites.asSequence()
            .groupBy ({ it[0] }, { it[1] })


        val attendables = hashSetOf<Int>()

        for (course in 0 until numCourses) {
            if (!attendables.contains(course) && !checkDFS(course, prereqs, attendables, hashSetOf<Int>())) {
                return false
            }
        }

        return true
    }

    fun checkDFS (course: Int, prereqs: Map<Int, List<Int>>, attendables: MutableSet<Int>, dependents: MutableSet<Int>): Boolean {
        if (prereqs.containsKey(course)) {
            dependents.add(course)

            for (requirement in prereqs.get(course)!!) {
                if (attendables.contains(requirement))
                    continue

                // cyclic dependency
                if (dependents.contains(requirement)) {
                    return false
                }

                if (!checkDFS(requirement, prereqs, attendables, dependents)) {
                    return false
                }
            }
        }

        attendables.add(course)
        dependents.remove(course)
        return true
    }
}