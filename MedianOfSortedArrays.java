// Time Complexity : O(log(m+n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] result = merge(nums1, nums2);
        double ans = 0.0d;
        if (result.length % 2 == 0) {
            ans = result[(result.length - 1) / 2] + result[((result.length - 1) / 2) + 1];
            ans /= 2;
        } else {
            ans = result[result.length / 2];
        }
        return ans;
    }

    // 1,2,3,4
    // 0,1,2,3
    private int[] merge(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] result = new int[m + n];
        int i = 0;
        int j = 0;
        int idx = 0;
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                result[idx++] = nums1[i++];
            } else {
                result[idx++] = nums2[j++];
            }
        }
        while (i < m) {
            result[idx++] = nums1[i++];
        }
        while (j < n) {
            result[idx++] = nums2[j++];
        }
        return result;
    }
}