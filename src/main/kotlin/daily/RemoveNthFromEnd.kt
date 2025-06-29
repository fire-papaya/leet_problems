/** Author temur.navoi
 *  Created on 4/18/21 17:09
 */

package daily

class RemoveNthFromEnd {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        if (head == null)
            return null

        var size = 0
        var slowNodeIndex = 0
        var fastNode = head
        var slowNode = ListNode(0).apply { this.next = head }

        while (fastNode != null) {
            size++

            if (size - n > slowNodeIndex) {
                slowNode = slowNode.next!!
                slowNodeIndex++
            }

            fastNode = fastNode.next
        }

        return if (size == n) {
            head.next
        } else {
            slowNode.next = slowNode.next?.next
            head
        }
    }
}