/** Author temur.navoi
 *  Created on 4/16/21 10:52
 */

package daily

class FibonacciNumber {

    fun fib(n: Int): Int {
        return if (n <= 1) n
            else fib (n - 1) + fib (n - 2)
    }
}