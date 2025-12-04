package medium;

public class MyJavaPow {
    double myPow(double x, int n) {
        var base = x;
        var result = 1D;

        var exp = Integer.valueOf(n).longValue();
        var absExp = Math.abs(exp);

        while (absExp > 0) {
            if ((absExp & 1L) == 1L) {
                result *= base;
            }

            base *= base;
            absExp = absExp >> 1;
        }

        if (exp < 0) {
            result = 1 / result;
        }

        return result;
    }
}
