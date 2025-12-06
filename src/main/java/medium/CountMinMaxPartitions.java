package medium;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class CountMinMaxPartitions {
    public int countPartitions(int [] nums, int k) {
        long modulo = 1_000_000_007;
        int n = nums.length;

        long[] dp = new long[nums.length + 1];
        long[] total = new long[nums.length + 1];
        dp[0] = 1;
        total[0] = 1;

        int j = 0;
        int i;

        var maxQueue = new ArrayDeque<Integer>();
        var minQueue = new ArrayDeque<Integer>();
        for (i = 0; i < n; i++) {
            int num = nums[i];

            while (!maxQueue.isEmpty() && nums[maxQueue.peekFirst()] <= num) {
                maxQueue.pollFirst();
            }
            maxQueue.offerFirst(i);

            while(!minQueue.isEmpty() && nums[minQueue.peekFirst()] >= num) {
                minQueue.pollFirst();
            }
            minQueue.offerFirst(i);

            while(!minQueue.isEmpty() && !maxQueue.isEmpty() && nums[maxQueue.peekLast()] - nums[minQueue.peekLast()] > k) {
                if (maxQueue.peekLast() == j) maxQueue.pollLast();
                if (minQueue.peekLast() == j) minQueue.pollLast();
                j++;
            }

            long partitions = (total[i] - (j > 0? total[j - 1] : 0) + modulo) % modulo;

            dp[i + 1] = partitions % modulo;
            total[i + 1] = (dp[i + 1] + total[i]) % modulo;
        }

        return (int)(dp[n] % modulo);
    }
}
