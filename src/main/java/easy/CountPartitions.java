package easy;

import java.util.Arrays;

public class CountPartitions {
    public int countPartitions(int[] nums) {
        int sum = 0;

        for (int n : nums) {
            sum += n;
        }

        return sum % 2 == 0 ? nums.length - 1: 0;
    }
}
