// Time Complexity : O(logN) N is length of small array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        int low=0;
        int high=m;
        if(m>n) return findMedianSortedArrays(nums2,nums1);
        while(low<=high){
            int pX=(low+high)/2;
            int pY=(m+n)/2-pX;
              
               int L1=pX==0?Integer.MIN_VALUE: nums1[pX-1];
               int L2=pY==0 ?Integer.MIN_VALUE: nums2[pY-1];
               int R1=pX==m?Integer.MAX_VALUE:nums1[pX];
               int R2=pY==n?Integer.MAX_VALUE:nums2[pY];
            
            if(L1<=R2 && L2<=R1){
                if((m+n)%2==0){
                    return (Math.max(L1,L2)+Math.min(R1,R2)+0.0)/2;
                }else{
                    return Math.min(R1,R2);
                }
            }else if(L2>R1){
                low=pX+1;
            }else{
                   high=pX-1;
            }
           
        }
        return 0.0;
      
    }
}