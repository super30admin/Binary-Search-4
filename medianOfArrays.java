// Time Complexity : O(log m)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : forgot to make sure 1st array is smaller than 2nd.

// Your code here along with comments explaining your approach

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        if(nums1 == null && nums2 == null)
            return 0.0;
        
        int n1 = nums1.length, n2 = nums2.length;
        
        if(n1 > n2) {
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int left = 0, right = n1;
        
        while(left <= right) {
        
            int partX = left + (right - left) / 2;        
            int partY = (n1 + n2) / 2 - partX;
            double l1 = partX - 1 < 0 ? Integer.MIN_VALUE : nums1[partX - 1];
            double l2 = partY - 1 < 0 ? Integer.MIN_VALUE : nums2[partY - 1];
            
            double r1 = partX >= n1 ? Integer.MAX_VALUE : nums1[partX];
            double r2 = partY >= n2 ? Integer.MAX_VALUE : nums2[partY];
            
            if(l1 <= r2 && l2 <= r1) {
                //even case
                if((n1 + n2) % 2 == 0)
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                else
                //odd case
                    return Math.min(r1, r2);
            }
            if(l1 > r2) {
                right = partX - 1;
            }
            else
                left = partX + 1;

        }
        
        return 0.0;
        
    }
}