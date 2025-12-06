package easy;

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        var buffer = new int[m];
        int i = 0, j = 0, k = 0, l = 0;

        for (i = 0; i < m; i++) {
            if (j < n && nums2[j] < nums1[i] && (l == k || nums2[j] <= buffer[k])) {
                buffer[l] = nums1[i];
                l++;

                nums1[i] = nums2[j];
                j++;
            }
            else if (l != k && buffer[k] < nums1[i] && (j >= n || buffer[k] < nums2[j])) {
                buffer[l] = nums1[i];
                l++;

                nums1[i] = buffer[k];
                k++;
            }
        }

        // remaining numbers
        for (i = m; i < m + n; i++) {
            if (l != k && (j >= n || buffer[k] < nums2[j])) {
                nums1[i] = buffer[k];
                k++;
            }
            else {
                nums1[i] = nums2[j];
                j++;
            }
        }
    }
}
