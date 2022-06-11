//TC:O(log(m+n))- m,n are lengths of two input arrays.
//SC:O(1)
// Did this code successfully run on Leetcode :  yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach/**
used binary search for the partition indices

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length,n=nums2.length;
        if(m>n) return findMedianSortedArrays(nums2,nums1);
        int low =0,high = m;
        while(low<=high){
            int partx = low+(high-low)/2;
            int party = (m+n)/2 - partx;
            double l1 = (partx==0?Integer.MIN_VALUE:nums1[partx-1]);
            double r1 = (partx==m?Integer.MAX_VALUE:nums1[partx]);
            double l2 = (party==0?Integer.MIN_VALUE:nums2[party-1]);
            double r2 = (party==n?Integer.MAX_VALUE:nums2[party]);
            if(r1<l2) low = partx+1;
            if(r2<l1) high =partx-1;
            if(l1<=r2 && l2<=r1){
                if((m+n) % 2 !=0){
                    return Math.min(r1,r2);
                }
                else{
                    double e1 = Math.max(l1,l2);
                    double e2 = Math.min(r1,r2);
                    return (e1+e2)/2;
                }
            }
        }
        return 0;
    }
}