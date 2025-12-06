package easy;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 1)
            return 1;

        int j = 0;
        for (int i = 1; i < nums.length; i++ ) {
            if (nums[j] != nums[i]) {
                j++;
                nums[j] = nums[i];
            }
        }

        return j;
    }
}
