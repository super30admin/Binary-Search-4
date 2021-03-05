// Time Complexity : O(log(min(m,n))
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
class Solution {
   
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // nums1 and nums2 are not empty
        int m = nums1.length;
        int n = nums2.length;
        if(m < n)
            return findMedian(nums1,nums2);
        else
            return findMedian(nums2,nums1);
    }
    
     public double findMedian(int[] nums1, int[] nums2) {
         
         int m = nums1.length;
         int n = nums2.length;
         
         int lo = 0;
         int hi = m;
         
         while(lo<=hi) {
             
             int mid1 = lo + (hi-lo)/2;
             int mid2 = ((m+n)/2)-mid1;
             
             double l1= mid1==0?Integer.MIN_VALUE: nums1[mid1-1];//left partition of nums1
             double r1= mid1==m?Integer.MAX_VALUE: nums1[mid1];//right partition of nums1
             double l2= mid2==0?Integer.MIN_VALUE: nums2[mid2-1];//left partition of nums2
             double r2= mid2==n?Integer.MAX_VALUE: nums2[mid2];//right partition of nums2
             
             if(l1<=r2 && l2<=r1){
                if((n+m)%2==0)
                    return ((Math.max(l2,l1))+Math.min(r1,r2))/2;
                else
                    return Math.min(r2,r1);                        
                }
                else if(l2>r1)
                {
                    lo=mid1+1;
                }
                else
                    hi=mid1-1;

            }
         
         return -1;
         
     }
    
}
