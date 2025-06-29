/** Author temur.navoi
 *  Created on 4/14/21 21:33
 */

package daily

class ListNode(var `val`: Int) {
     var next: ListNode? = null
}

class PartitionList {
    fun partition(head: ListNode?, x: Int): ListNode? {
        val lesserNodesHead = ListNode(Int.MAX_VALUE)
        val greaterNodesHead = ListNode(Int.MAX_VALUE)
        return buildPartitions(head, lesserNodesHead, lesserNodesHead, greaterNodesHead, greaterNodesHead, x).next
    }

    private fun buildPartitions (
        iterHead: ListNode?,
        lesserNodesHead: ListNode,
        lesserNodesTail: ListNode,
        greaterNodesHead: ListNode,
        greaterNodesTail: ListNode,
        x: Int
    ): ListNode {
        return if (iterHead == null) {
            greaterNodesTail.next = null
            lesserNodesTail.next = greaterNodesHead.next
            lesserNodesHead
        } else if (iterHead.`val` < x) {
            lesserNodesTail.next = iterHead
            buildPartitions(iterHead.next, lesserNodesHead, lesserNodesTail.next!!, greaterNodesHead, greaterNodesTail, x)
        } else {
            greaterNodesTail.next = iterHead
            buildPartitions(iterHead.next, lesserNodesHead, lesserNodesTail, greaterNodesHead, greaterNodesTail.next!!, x)
        }
    }
}