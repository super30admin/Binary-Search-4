// Median of Two Sorted Arrays

// Time Complexity : O(log n1), where n1 is the length of the smaller array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -


// Your code here along with comments explaining your approach

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length == 0 && nums2.length == 0)
            return 0.0;
        if(nums1.length > nums2.length)
            return findMedianSortedArrays(nums2, nums1);
        int n1 = nums1.length;
        int n2 = nums2.length;
        int low = 0;
        int high = n1;
        while(low <= high){
            int part_x = low + (high - low) / 2;
            int part_y = ((n1 + n2) / 2) - part_x;

            double l1 = (part_x == 0) ? Integer.MIN_VALUE : nums1[part_x - 1];
            double r1 = (part_x == n1) ? Integer.MAX_VALUE : nums1[part_x];
            double l2 = (part_y == 0) ? Integer.MIN_VALUE : nums2[part_y - 1];
            double r2 = (part_y == n2) ? Integer.MAX_VALUE : nums2[part_y];

            if(l1 <= r2 && l2 <= r1){
                //partition found
                if((n1 + n2) % 2 == 0){
                    return (Math.max(l1, l2) + Math.min(r1, r2))/2;
                } else {
                    return Math.min(r1, r2);
                }
            } else if(l1 > r2){
                high = part_x - 1;
            } else{
                low = part_x + 1;
            }
        }
        return 123.0;
    }
}