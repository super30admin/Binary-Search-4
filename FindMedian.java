// Time Complexity :O(logm) where m is size of smaller array
// Space Complexity :constant
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No

//we will do binary search on partitions of smaller array and try to find adequate partition in larger array
//so that max of left of both is smaller than min of both the rights of both partitions
//if total elements are even we'll return average of  max of left of both and min of both the rights
//else we'll return min of rights
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null && nums2 == null)
            return 0.0000;
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int start = 0;
        int end = m;
        while (start <= end) {
            int partX = start + (end - start) / 2;
            int partY = (n + m) / 2 - partX;

            double l1 = (partX == 0) ? Integer.MIN_VALUE : nums1[partX - 1];
            double l2 = (partY == 0) ? Integer.MIN_VALUE : nums2[partY - 1];
            double r1 = (partX == m) ? Integer.MAX_VALUE : nums1[partX];
            double r2 = (partY == n) ? Integer.MAX_VALUE : nums2[partY];
            if (l1 <= r2 && l2 <= r1) {
                if ((n + m) % 2 == 0) {

                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2;
                } else {
                    return Math.min(r1, r2);
                }
            } else if (l2 > r1) {
                start = partX + 1;

            } else {
                end = partX - 1;
            }
        }
        return 0.0000;
    }
}