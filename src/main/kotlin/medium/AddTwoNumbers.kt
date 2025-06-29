/** Author temur.navoi
 *  Created on 03/05/21 21:58
 */

package medium

class AddTwoNumbers {

    inner class ListNode(var `val`: Int) {
         var next: ListNode? = null
    }


    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var num1 = l1
        var num2 = l2
        var remainder = 0
        val sum = ListNode(0)
        var moving = sum

        while (num1 != null || num2 != null || remainder != 0) {
            val tempVal = (num1?.`val` ?: 0) + (num2?.`val` ?: 0) + remainder

            remainder = if (tempVal > 9) 1 else 0

            moving.next = ListNode(tempVal % 10)
            moving = moving.next!!

            num1 = num1?.next
            num2 = num2?.next

        }

        return sum.next ?: sum
    }
}