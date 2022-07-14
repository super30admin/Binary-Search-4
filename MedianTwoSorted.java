// Time Complexity : O(log(min(m,n)))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


class MedianTwoSorted {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums2.length<nums1.length)
            return findMedianSortedArrays(nums2,nums1);
        
        int m = nums1.length;
        int n = nums2.length;
        
        int low = 0;
        int high = nums1.length;
        
        while(low<=high) {
            int xp = low+(high-low)/2;
            int yp = (m+n)/2-xp;
            
            int l1 = (xp==0) ? Integer.MIN_VALUE : nums1[xp-1];
            int r1 = (xp==m) ? Integer.MAX_VALUE : nums1[xp];
            
            int l2 = (yp==0) ? Integer.MIN_VALUE : nums2[yp-1];
            int r2 = (yp==n) ? Integer.MAX_VALUE : nums2[yp];
            
            if(l1<=r2 && l2<=r1) {
                if((m+n)%2!=0)
                    return (double)Math.min(r1,r2);
                else
                    return (double)(Math.max(l1,l2)+Math.min(r1,r2))/2;
            }else if(r1<l2){
                low = xp+1;
            }else{
                high = xp-1;
            }
        }
        
        return -1;
    }
}
