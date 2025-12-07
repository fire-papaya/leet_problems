package medium;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        if (nums.length == k)
            return;

        int n = nums.length;
        int k1 = k % n;
        if (k1 == 0)
            return;

        int cycles = gcd(n, k);

        for (int start = 0; start < cycles; start++) {
            int curr = start;
            int prev = nums[start];

            do {
                int next = (curr + k1) % n;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                curr = next;
            } while (curr != start);
        }

        return;
        // brute-force

//        int[] buff = new int[n];
//
//        for (int i = 0; i < n; i++) {
//            buff[(i + k1) % n] = nums[i];
//        }
//
//        for (int i = 0; i < n; i++) {
//            nums[i] = buff[i];
//        }
    }
    private int gcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
}
