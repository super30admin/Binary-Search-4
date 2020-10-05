//Time Complexity-O(logn)
//Space Complexity-O(1)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
       if(n>m)
       {
           return findMedianSortedArrays(nums2,nums1);
       }
       int low=0;
       int high=n;
       while(low<=high)
       {
            int partx=low+(high-low)/2;
            int party=(n+m+1)/2-partx;
           
            double l1=partx==0?Integer.MIN_VALUE:nums1[partx-1];
            double l2=party==0?Integer.MIN_VALUE:nums2[party-1];
            double r1=partx==n?Integer.MAX_VALUE:nums1[partx];
            double r2=party==m?Integer.MAX_VALUE:nums2[party];
           if(l1<=r2 &&l2<=r1)
           {
               if((n+m)%2==0)
               {
                   return (Math.max(l1,l2)+Math.min(r1,r2))/2;
               }
               else{
                   return Math.max(l1,l2);
               }
           }
           else if(l2>r1)
           {
               low=partx+1;
           }
           else{
               high=partx-1;
           }
       }
        return -1;
    }
}