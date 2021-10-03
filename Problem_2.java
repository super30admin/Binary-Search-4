// Time Complexity : O(log(m+n))
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// get the mid of smallest array, then get the partition of the big array, then compare the low and high of each other array, and if they satisfy the condition return the result.
// Your code here along with comments explaining your approach
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length == 0 && nums2.length == 0){
            return 0.0;
        }
        int n1 = nums1.length;
        int n2 = nums2.length;
        if( n1 > n2 ) return findMedianSortedArrays(nums2, nums1);
        int low = 0; int high = n1;
        while(low<= high){
            int part1 = low + (high - low) / 2;
            int part2 = ((n1 + n2) / 2) - part1;
            double l1 = part1 == 0 ? Integer.MIN_VALUE : nums1[part1-1];
            double l2 = part2 == 0 ? Integer.MIN_VALUE : nums2[part2-1];
            double r1 = part1 == n1 ? Integer.MAX_VALUE : nums1[part1];
            double r2 = part2 == n2 ? Integer.MAX_VALUE : nums2[part2];
            if( l1 <= r2 && l2 <= r1){
                if( (n1 + n2) % 2 == 0){
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2;
                }else{
                    return( Math.min(r1, r2));
                }
            }else if( l1 > r2){
                high = part1 - 1;
            }else{
                low = part1 + 1;
            }
        }
        return 10.0;
    }
}