/** Author temur.navoi
 *  Created on 4/20/21 21:43
 */

package daily

class Node(var `val`: Int) {
     var children: List<Node?> = listOf()
}

class NAryTreeTraversal {
    fun preorder(root: Node?): List<Int> {
        val result = arrayListOf<Int>()
        if (root != null)
            traverse(root, result)
        return result
    }

    private fun traverse (root: Node, elements: ArrayList<Int>) {
        elements.add(root.`val`)

        for (child in root.children) {
            traverse(child!!, elements)
        }
    }
}