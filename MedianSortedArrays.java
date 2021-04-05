// Time Complexity : O(log n) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// initializing array sizes n1 and n2
// check which array is smaller
// binary search on smaller array
// calculate parititions
// check l1 <= r2 && l2 <= r1 then, check if odd or even and return accordingly
// check which side ot move on

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1=nums1.length;
        int n2=nums2.length;
        
        if(n1>n2){
            findMedianSortedArrays(nums2,nums1);
        }
            int low=0; int high=n1;
            while(low<=high){
                int mid=low+(high-low)/2;
                
                int partX=mid;
                int partY=(n1+n2+1) / 2 - partX;
                
                double L1 = partX==0? Integer.MIN_VALUE: nums1[partX - 1];
                double R1 = partX==n1? Integer.MAX_VALUE : nums1[partX];
                
                double L2 = partY==0? Integer.MIN_VALUE: nums2[partY - 1];
                double R2 = partY==n2? Integer.MAX_VALUE : nums2[partY];
                
                if(L1<=R2 && L2<=R1){
                    if((n1+n2)%2==0){
                        return (Math.max(L1,L2)+Math.min(R1,R2))/2;
                    }
                    else{
                        return Math.max(L1,L2);
                    }
                }
                else if (L2>R1){
                    low=mid+1;
                }
                else{
                    high=mid-1;
                }
            }
            return -1;
    }
}