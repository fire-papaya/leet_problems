package easy

import java.util.Stack

class Solution {
    fun isValid(s: String): Boolean {
        val closingOf = mapOf(
            '(' to ')',
            '{' to '}',
            '[' to ']'
        )

        val stack: Stack<Char> = Stack<Char>()

        for (c in s) {
            if (closingOf.containsKey(c))
                stack.push(c)
            else if (!stack.isEmpty() && c == closingOf[stack.peek()]!!)
                stack.pop()
            else
                return false
        }

        return stack.isEmpty()
    }
}