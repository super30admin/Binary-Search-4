// Time Complexity :  O(log(min(n,m)))
// Space Complexity : O(1) since it is iterative binary search.
// Did this code successfully run on Leetcode : Yes Its working
// Any problem you faced while coding this : understanding the problem iteself.
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null) return 0.0;
       
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n1>n2) return findMedianSortedArrays(nums2,nums1);
        int low = 0 ;
        int high = n1;
        double l1 = 0, l2 = 0, r1 = 0, r2 = 0;
        while(low<=high)
        {
            int midX = (high-low)/2 + low;
            int midY = (n1+n2+1)/2 - midX;
            l1 = midX==0?Integer.MIN_VALUE:nums1[midX-1];
            r1 = midX==n1?Integer.MAX_VALUE:nums1[midX];
            l2 = midY==0?Integer.MIN_VALUE:nums2[midY-1];
            r2 = midY==n2?Integer.MAX_VALUE:nums2[midY];
            if(l1<=r2 && l2<=r1) 
            {
                if((n1+n2)%2==0)
                {
                    return (Math.max(l1,l2)+Math.min(r1,r2))/2;
                }
                else return (double)Math.max(l1,l2);
            }
            else if(l2>r1) low = midX+1;
            else  high = midX-1;
        }
        
        return -1;

    
    }
}