// Time Complexity : O(log(min(n1,n2))) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        
        if(n1 > n2) return findMedianSortedArrays(nums2, nums1);
        
        int low = 0, high = n1;
        
        while(low <= high){
            int mid = low + (high - low)/2;
            
            int partAr1 = mid;
            int partAr2 = (n1+n2+1)/2 - partAr1;
            
            double L1 = partAr1 == 0? Integer.MIN_VALUE: nums1[partAr1-1];
            double R1 = partAr1 == n1? Integer.MAX_VALUE: nums1[partAr1];
            
            double L2 = partAr2 == 0? Integer.MIN_VALUE: nums2[partAr2-1];
            double R2 = partAr2 == n2? Integer.MAX_VALUE: nums2[partAr2];
            
            if(L1 <= R2 && L2 <= R1){
                //even or odd
                if( (n1+n2)%2 == 0){
                    return (Math.max(L1,L2) + Math.min(R1,R2))/2;
                }
                return Math.max(L1,L2);
            }else if(L2 > R1){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return -1;
    }
}
