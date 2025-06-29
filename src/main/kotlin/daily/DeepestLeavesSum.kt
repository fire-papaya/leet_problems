/** Author temur.navoi
 *  Created on 4/11/21 20:16
 */

package daily

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 *
**/

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class TreeTraverser {
    var maxDepth: Int = 1
    var currentDepth: Int = 1
    var sum: Int = 0
}

class DeepestLeavesSum {
    fun deepestLeavesSum(root: TreeNode?): Int {

        if (root == null)
            return 0

        val traverser = TreeTraverser()

        traverseTreeAndSum(root, traverser)

        return traverser.sum
    }

    private fun traverseTreeAndSum (root: TreeNode, traverser: TreeTraverser) {
        if (root.left != null || root.right != null) {
            if (root.left != null) {
                traverseTreeAndSum(root.left!!, traverser.apply { this.currentDepth += 1 })
                traverser.currentDepth -= 1
            }

            if (root.right != null) {
                traverseTreeAndSum(root.right!!, traverser.apply { this.currentDepth += 1 })
                traverser.currentDepth -= 1
            }
        } else if (traverser.currentDepth > traverser.maxDepth) {
            traverser.maxDepth = traverser.currentDepth
            traverser.sum = root.`val`
            return
        } else if (traverser.currentDepth == traverser.maxDepth) {
            traverser.sum += root.`val`
            return
        }
    }
}