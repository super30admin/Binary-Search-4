// Time Complexity : O(log min(m+n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n1 > n2)
            return findMedianSortedArrays(nums2, nums1);
        
        int low = 0; int high = n1;
        while(low <= high){
            int partX = low + (high - low)/2;
            int partY = (n1 + n2)/2 - partX;
            double l1, l2, r1, r2;
            if(partX == 0)
                l1 = Integer.MIN_VALUE;
            else
                l1 = nums1[partX - 1];
            if(partX == n1)
                r1 = Integer.MAX_VALUE;
            else
                r1 = nums1[partX];
            
            if(partY == 0)
                l2 = Integer.MIN_VALUE;
            else
                l2 = nums2[partY - 1];
            if(partY == n2)
                r2 = Integer.MAX_VALUE;
            else
                r2 = nums2[partY];
            
            if(l1 <= r2 && l2 <= r1){
                if((n1 + n2)%2 == 0){
                    return (Math.max(l1, l2) + Math.min(r1, r2))/2;
                }else{
                    return Math.min(r1, r2);
                }
            }
            else if(l2 > r1){
                low = partX + 1;
            }
            else{
                high = partX - 1;
            }
        }
        return 9999;
    }
}