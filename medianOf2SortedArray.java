// Time Complexity : O(log(min(n1,n2))), n1 and n2 are the length of nums1 and nums2
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach in three sentences only
/*
 * create partition for both array, if the partition values , L1 and L2 are smaller than R1 and R2 then we found correct partition.
 *else we move right or left based of the l1 and l2 comparison.
 * if  total elements are even we take the average or else we take the min from the right partition.
 */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        if (n1 > n2)
            return findMedianSortedArrays(nums2, nums1);

        int low = 0, high = n1;
        while (low <= high) {
            int partX = low + (high - low) / 2;
            int partY = (n1 + n2) / 2 - partX;

            double L1 = partX == 0 ? Integer.MIN_VALUE : nums1[partX - 1];
            double R1 = partX == n1 ? Integer.MAX_VALUE : nums1[partX];

            double L2 = partY == 0 ? Integer.MIN_VALUE : nums2[partY - 1];
            double R2 = partY == n2 ? Integer.MAX_VALUE : nums2[partY];
            if (L1 <= R2 && L2 <= R1) {
                // found correct partition and median
                if ((n1 + n2) % 2 == 0) {
                    return (Math.min(R1, R2) + Math.max(L1, L2)) / 2;
                } else {
                    return Math.min(R1, R2);
                }
            } else if (L1 > R2) {
                high = partX - 1;
            } else {
                low = partX + 1;
            }
        }

        return 8.233;
    }
}