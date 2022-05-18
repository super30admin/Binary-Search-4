/*
Problem: https://leetcode.com/problems/median-of-two-sorted-arrays/
TC:O(log(min(n1,n2)))
SC: O(1)
*/
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if ((nums1 == null && nums2 == null) || (nums1.length == 0 && nums2.length == 0)) {
            return 0.0;
        }
        
        if (nums2.length < nums1.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int low = 0;
        int high = nums1.length;
        int n1 = nums1.length;
        int n2 = nums2.length;
        
        while (low <= high) {
            int partitionX = low + (high - low) / 2;
            int partitionY = ((n1 + n2) / 2) - partitionX;
            int L1 = (partitionX == 0 ? Integer.MIN_VALUE : nums1[partitionX - 1]);
            int L2 = (partitionY == 0 ? Integer.MIN_VALUE : nums2[partitionY - 1]);
            int R1 = (partitionX == n1 ? Integer.MAX_VALUE : nums1[partitionX]);
            int R2 = (partitionY == n2 ? Integer.MAX_VALUE : nums2[partitionY]);
            
            if (L1 <= R2 && L2 <= R1) {
                if ((n1 + n2) % 2 == 0) {
                    return (Math.max(L1, L2) + Math.min(R1, R2)) / 2.0;
                } else {
                    // Right side will always have more elements if total number of elements are odd
                    return Math.min(R1, R2);
                }
            } else if (L2 > R1) {
                low = partitionX + 1;
            } else {
                high = partitionX - 1;
            }
        }
        
        return 0.0;
    }
}