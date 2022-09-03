// Time Complexity : O(logn1) where n1 = number of elements of smaller array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
//4. Median of Two Sorted Arrays (Hard) - https://leetcode.com/problems/median-of-two-sorted-arrays/
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0 && nums2.length == 0) return 0.0;
        
        if (nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);
        
        int n1 = nums1.length, n2 = nums2.length, start = 0, end = n1;
        
        while (start <= end) {
            int partitionX = start + (end-start)/2;
            int partitionY = (n1+n2)/2 - partitionX;
            double l1 = partitionX == 0 ? Integer.MIN_VALUE : nums1[partitionX-1];
            double r1 = partitionX == n1 ? Integer.MAX_VALUE : nums1[partitionX];
            double l2 = partitionY == 0 ? Integer.MIN_VALUE : nums2[partitionY-1];
            double r2 = partitionY == n2 ? Integer.MAX_VALUE : nums2[partitionY];
            
            if (l1 <= r2 && l2 <= r1) { // correct partition
                if ((n1 + n2) % 2 == 0) { // if even sized, median is mean value of left and right elements of partition
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2;
                } else { // if odd sized, median is next to the partition
                    return Math.min(r1, r2);
                }
            } else if (l2 > r1) {
                start = partitionX + 1;
            } else {
                end = partitionX - 1;
            }
        }
        
        return 1.0;
    }
}