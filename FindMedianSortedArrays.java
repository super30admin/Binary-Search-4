// Problem 4. Median of Two Sorted Arrays
// Time Complexity : O(log(min(m,n)))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Ensure nums1 is the smaller array to perform binary search on the smaller one
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int m = nums1.length;
        int n = nums2.length;
        int left = 0, right = m;
        int halfLen = (m + n + 1) / 2;
        while (left <= right) {
            int i = left + (right - left) / 2;
            int j = halfLen - i;
            if (i < right && nums2[j - 1] > nums1[i]) {
                // i is too small, must increase it
                left = i + 1;
            } else if (i > left && nums1[i - 1] > nums2[j]) {
                // i is too big, must decrease it
                right = i - 1;
            } else {
                // i is perfect

                // Handle edge cases where i or j is at the boundary of an array
                int maxLeft;
                if (i == 0) {
                    maxLeft = nums2[j - 1];
                } else if (j == 0) {
                    maxLeft = nums1[i - 1];
                } else {
                    maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                }

                // If the total length is odd, return maxLeft as the median
                if ((m + n) % 2 == 1) {
                    return maxLeft;
                }
                int minRight;
                if (i == m) {
                    minRight = nums2[j];
                } else if (j == n) {
                    minRight = nums1[i];
                } else {
                    minRight = Math.min(nums1[i], nums2[j]);
                }
                // If the total length is even, return the average of maxLeft and minRight
                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }
}
