//https://leetcode.com/problems/median-of-two-sorted-arrays/
// Time Complexity : O(mlogn) m<n
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length==0 && nums2.length==0) return 0.0;
        if(nums1.length>nums2.length) return findMedianSortedArrays(nums2,nums1);
        return bs(nums1,nums2);
    }
    private double bs(int[] nums1,int[] nums2)
    {
        //we have n+1 partitions for n elements and bs is on partitions
        int low=0,high=nums1.length;
        while(low<=high)
        {
            int partX=low+(high-low)/2;
            int partY=(nums1.length+nums2.length)/2 - partX;
            //find the edge elements
           double l1=(partX==0)?Integer.MIN_VALUE:nums1[partX-1];
            double l2=(partY==0)?Integer.MIN_VALUE:nums2[partY-1];
            double r1=(partX==nums1.length)?Integer.MAX_VALUE:nums1[partX];
            double r2=(partY==nums2.length)?Integer.MAX_VALUE:nums2[partY];
            //all left elements should be less than right elements since l1<r1 l2<r2 check criss crossly
            if(l1>r2)
            {
                high=partX-1;
            }
            if(l2>r1)
            {
                low=partX+1;
            }
            if(l1<=r2 && l2<=r1)
            {
                //check if total number of elements are odd
                if(((nums1.length+nums2.length)%2==1))
                    return Math.min(r1,r2);
                else
                    return (Math.max(l1,l2)+Math.min(r1,r2))/2;
            }
        }
        return 0.0;
    }
}