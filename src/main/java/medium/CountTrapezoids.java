package medium;

import java.util.ArrayList;
import java.util.HashMap;

public class CountTrapezoids {
    public int countTrapezoids(int[][] points) {
        HashMap<Integer, ArrayList<int[]>> pointMap = new HashMap<>();

        for (int[] point : points) {
            pointMap.computeIfAbsent(point[1], k -> new ArrayList<>())
                    .add(point);
        }

        HashMap<Integer, Long> memo = new HashMap<>();


        for (Integer key : pointMap.keySet()) {
            if (pointMap.get(key).size() > 1) {
                memo.put(key, nChooseM(pointMap.get(key).size(), 2));
            }
        }

        long result = 0L;
        long runningSum = 0;

        for (Long count : memo.values()) {
            result += runningSum * count;
            result %= 1_000_000_007;
            runningSum += count;
        }

        return (int) result;
    }

    long nChooseM(int n, int m) {
        if (m > n) return 0;
        if (m == 0 || m == n) return 1;

        m = Math.min(m, n - m);  // symmetry: C(n, m) = C(n, n-m)

        long result = 1;
        for (int i = 1; i <= m; i++) {
            result = result * (n - i + 1) / i;
        }

        return result;
    }

}
