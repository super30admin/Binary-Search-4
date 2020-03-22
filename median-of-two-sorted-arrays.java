// Time Complexity : O(log(min(m,n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length, n=nums2.length;
        if(m > n)
            return findMedianSortedArrays(nums2, nums1);
        
        int low=0, high=m;
        int maxLeftX, maxLeftY, minRightX, minRightY;
        int pX, pY;
        
        while(low <= high){
            pX = low+(high-low)/2;
            pY = (m+n+1)/2 - pX;
            
            if (pX == 0) {
                maxLeftX = Integer.MIN_VALUE;
            } else {
                maxLeftX = nums1[pX - 1];
            }

            if (pX == m) {
                minRightX = Integer.MAX_VALUE;
            } else {
                minRightX = nums1[pX];
            }

            if (pY == 0) {
                maxLeftY = Integer.MIN_VALUE;
            } else {
                maxLeftY = nums2[pY - 1];
            }

            if (pY == n) {
                minRightY = Integer.MAX_VALUE;
            } else {
                minRightY = nums2[pY];
            }
            
            if(maxLeftX <= minRightY && maxLeftY <= minRightX)
            {
                if((m+n)%2 == 0)
                    return (Math.max(maxLeftX, maxLeftY)+Math.min(minRightX, minRightY))/2.0;
                else
                    return Math.max(maxLeftX, maxLeftY);
            } else if (maxLeftX > minRightY){
                high = pX-1;
            } else {
                low = pX+1;
            }
        }
        return 0.0;
    }
}
