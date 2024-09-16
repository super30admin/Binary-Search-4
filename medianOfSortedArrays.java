// Time Complexity : O(m + n) where m and n are the lengths of nums1 and nums2 respectively
// Space Complexity : O(m + n) to store the array containing all the elements in the sorted order
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class medianOfSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double[] ans = new double[nums1.length + nums2.length];
        int i = 0, j = 0, idx = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                ans[idx] = nums1[i];
                i++;
            }
            else {
                ans[idx] = nums2[j];
                j++;
            }
            idx++;
        }
        while (i < nums1.length) {
            ans[idx] = nums1[i];
            i++;
            idx++;
        }
        while (j < nums2.length) {
            ans[idx] = nums2[j];
            j++;
            idx++;
        }
        if (ans.length % 2 == 1) {
            return ans[ans.length / 2];
        } else return (ans[ans.length / 2] + ans[ans.length / 2 - 1]) / 2;
    }
}