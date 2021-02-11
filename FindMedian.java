// Time Complexity : O(logn) where n is the smaller fo the two lists
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


//Your code here along with comments explaining your approach
// Partition smmaller array using Binary Search
// Calculate Partition 2 = (n+m)/2 - partition1
// If all elements on left are less than all elements on right, then we have a desired partition
// Handle odd and even cases when we find the partition


class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if(nums1 == null || nums2 == null) return 0.0;

        int n1 = nums1.length; //n1 smaller
        int n2 = nums2.length;

        if(n1 > n2) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int low = 0;
        int high = n1;
        while(low <= high) {
            int partition1 = low + (high - low) /2;
            int partition2 = (n1+n2) / 2 - partition1;

            double l1 = partition1 == 0 ? Integer.MIN_VALUE : nums1[partition1 -1];
            double l2 = partition2 == 0 ? Integer.MIN_VALUE : nums2[partition2 -1];
            double r1 = partition1 == n1 ? Integer.MAX_VALUE : nums1[partition1];
            double r2 = partition2 == n2 ? Integer.MAX_VALUE : nums2[partition2];


            if(l1 <= r2 && l2 <= r1) { //Partition found
                if((n1+n2) % 2 == 0) {
                    double median = (Math.max(l1,l2) + Math.min(r1,r2))/ 2;
                    return median;
                } else {
                    return Math.min(r1,r2);
                }

            } else if(l1 > r2) {
                high = partition1 - 1;
            } else {
                low = partition1 + 1;
            }

        }
        return -1;
    }
}
