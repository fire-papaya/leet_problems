package easy

import kotlin.math.pow
import kotlin.math.sign

class ReverseInteger {
    fun reverse(x: Int): Int {
        val sign = x.toDouble().sign
        var num = (x * sign).toInt()
        val residues = arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
        var size = 0

        while (num > 0) {
            val residue = num % 10
            residues[size] = residue
            num /= 10
            size++
        }

        var reversed = 0

        for (i in 0 until size) {
            reversed += (10.toDouble().pow(size - (i + 1)) * residues[i]).toInt()
        }

        return if (sign(x.toDouble() * sign) != sign(reversed.toDouble())) 0
        else sign.toInt() * reversed
    }
}