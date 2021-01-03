// Time Complexity : O(log(min(m, n)))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NA


// Your code here along with comments explaining your approach

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        if(nums1 == null && nums2 == null) return 0;
        
        int m = nums1.length;
        int n = nums2.length;
        
        if(m > n) {
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int low = 0, high = m;
        
        while(low <= high) {
            
            int partX = low + (high - low)/2;
            int partY = (m + n)/2 - partX;
            double l1 = (partX - 1 < 0) ? Integer.MIN_VALUE : nums1[partX - 1];
            double l2 = (partY - 1 < 0) ? Integer.MIN_VALUE : nums2[partY - 1];
            double r1 = (partX == m) ? Integer.MAX_VALUE : nums1[partX];
            double r2 = (partY == n) ? Integer.MAX_VALUE : nums2[partY];
            
            if(l1 <= r2 && l2 <= r1) {
                if((m + n) % 2 == 0) {
                    return (Math.max(l1, l2) + Math.min(r1, r2))/2;
                }
                else {
                    return Math.min(r1, r2);
                }
            }
            else if(l1 > r2) {
                high = partX - 1;
            }
            else if(l2 > r1) {
                low = partX + 1;
            }
        }
        return 0;
    }
}