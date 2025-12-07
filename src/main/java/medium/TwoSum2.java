package medium;

public class TwoSum2 {
    public int[] twoSum(int[] numbers, int target) {
        // straightforward "brute-force" Solution with O(n) space:
        // create a hashmap: value -> index
        //    iterate through hashmap keys,
        //    find hashmap[target-value]
        //    return two indices: [hashmap[value], hashmap[target-value]]
        int n = numbers.length;
        int[] result = new int[2];
        int i = 0;
        int j = 0;

        int previ = Integer.MIN_VALUE;
        for (i = 0; i < n - 1; i++) {
            if (previ == numbers[i])
                continue;

            previ = numbers[i];
            int left = i;
            int right = n;

            while (left < right) {
                j = (left + right) / 2;

                if (numbers[i] + numbers[j] < target) {
                    left = j;
                } else if (numbers[i] + numbers[j] > target) {
                    right = j;
                } else {
                    return new int[]{i + 1, j + 1};
                }
            }
        }

        return new int[]{1, n};
    }

    public int[] twoSum2(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[]{-1, -1};
    }
}
