// Time Complexity : O(logm)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no

// Approach 

// We use Binary Search to solve this
// We take the low and high for one of the arrays(smaller)
// We make the partitions and get l1,l2,r1,r2 values
// we check if the l1 <=r2 and l2 <=r1 if not we make changes to low and high to satisfy the condition
// if the total no of elements are even, we take the average of Min(r1,r2) and max(l1,l2)
// else we return the min r1 and r2
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0 && nums2.length == 0)
            return 0.0;
        int n1 = nums1.length;
        int n2 = nums2.length;
        if (n2 < n1)
            return findMedianSortedArrays(nums2, nums1);

        int low = 0, high = n1;
        while (low <= high) {
            int partX = low + (high - low) / 2;
            int partY = (n1 + n2) / 2 - partX;
            double l1 = partX == 0 ? Integer.MIN_VALUE : nums1[partX - 1];
            double r1 = partX == n1 ? Integer.MAX_VALUE : nums1[partX];
            double l2 = partY == 0 ? Integer.MIN_VALUE : nums2[partY - 1];
            double r2 = partY == n2 ? Integer.MAX_VALUE : nums2[partY];

            if (l1 <= r2 && l2 <= r1) {
                if ((n1 + n2) % 2 == 0) {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2;
                } else {
                    return Math.min(r1, r2);
                }
            } else if (l1 > r2) {
                high = partX - 1;
            } else {
                low = partX + 1;
            }
        }
        return 132.123;
    }
}