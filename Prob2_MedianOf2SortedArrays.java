// Time Complexity : O(Log N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        if(nums1 == null || nums2 == null)  return 0.0;
        int len1 = nums1.length; 
        int len2 = nums2.length;
        
        if(len2 < len1) return findMedianSortedArrays(nums2, nums1);
        
        //Keeping nums1 as smaller everytime
        int low = 0;
        int high = len1;
        
        while(low <= high){
            int pX = low + (high - low)/2; // Binary Search on Nums1
            
            int pY = (len1+len2)/2 - pX;
            
            //Finding 4 elements to check if partition is valid or not
            double l1 = pX == 0 ? Integer.MIN_VALUE : nums1[pX - 1] ;
            double r1 = pX == len1 ?  Integer.MAX_VALUE : nums1[pX] ;
            
            double l2 = pY == 0 ? Integer.MIN_VALUE : nums2[pY - 1] ;
            double r2 = pY == len2 ?  Integer.MAX_VALUE : nums2[pY] ;
            
            if(l1 <= r2 && l2 <= r1){ // Valid Partition
                if((len1+len2)%2 == 0)  { 
                    return ( Math.min(r1, r2) + Math.max(l1, l2) ) / 2;
                }
                else  return Math.min(r1,r2);
                
            }else if(l2 > r1){
                low = pX + 1;
            }else{ //(l1 > r2)
                high = pX - 1;
            }
        }
        
        return -1.00;
        
    }
}