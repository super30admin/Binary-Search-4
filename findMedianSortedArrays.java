class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int m=nums1.length;
        int n= nums2.length;
        
        
        if(m==0 && n==0) return 0.0;
        
        if(m==0)
            if(n%2==1)
                return nums2[n/2];
            else
                return (nums2[n/2]+nums2[n/2-1])/2.0;
        if(n==0)
            if(m%2==1)
                return nums1[m/2];
            else
                return (nums1[m/2]+nums1[m/2-1])/2.0;
        
        if(m>n)
            return findMedianSortedArrays(nums2,nums1);
        
        int l=0;
        int h=m;
        
        while(l<=h)
        {
            
            int part1=l+(h-l)/2;
            int part2=(m+n)/2-part1;
            
            int l1=(part1==0)?Integer.MIN_VALUE:nums1[part1-1];
            int r1=(part1==m)?Integer.MAX_VALUE:nums1[part1];
            int l2=(part2==0)?Integer.MIN_VALUE:nums2[part2-1];
            int r2=(part2==n)?Integer.MAX_VALUE:nums2[part2];
            
            if(l2<=r1 && l1<=r2)
            {
                if((m+n)%2==1)
                    return Math.min(r1,r2);
                else
                    return (Math.max(l1,l2)+Math.min(r1,r2))/2.0;
            }
            else if(r2>l1)
                l=part1+1;
            else 
                h=part1-1;
        }
        
        
        return -100;
        
        
        
        
    }
}

// Time Complexity : O(MlogM)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no