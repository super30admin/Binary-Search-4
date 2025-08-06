// Time Complexity : O(log(m)) where m is the minimum of the 2 lengths
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

// Approach : I use partitions in both the arrays, logic is that on the left side should be (m+n)/2 elements and on the right side too - so I partition such that I take x elements from the first array and y from second such that y = (m+n)/2-x so it has remaining elememts - I want to check if I partitioned it correctly so that all elements to the left and smaller than the right, this would mean that l1 (left side of nums1) is smaller than r2 (right side of l2) and l2 is smaller than r1. If I find this configuration, I return the median based on the size of m+n, else I keep moving - if l1>r2 it means I am too far on the first array, so I move my high behind, else if l2>r1 it means I am too behind on the first array so I move low ahead. 

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // meadian is the middle value
        int m = nums1.length;
        int n = nums2.length;
        if(n<m) return findMedianSortedArrays(nums2, nums1);
        int low = 0;
        int high = m;
        while(low<=high){
            int partX = low+(high-low)/2;
            int partY = (m+n)/2-partX;
            int l1 = partX==0?Integer.MIN_VALUE:nums1[partX-1];
            int l2 = partY==0?Integer.MIN_VALUE:nums2[partY-1];
            int r1 = partX==m ? Integer.MAX_VALUE : nums1[partX];
            int r2 = partY==n ? Integer.MAX_VALUE : nums2[partY];
            if(l1<=r2 && l2<=r1){ // both are in exact middle of the combined sorted arrays
                if((m+n)%2==0) return (Math.max(l1,l2) + Math.min(r1,r2))/2.0;
                return Math.min(r1,r2);
            } 
            if(l1>r2) high = partX-1;
            else low = partX+1;
        }
        return -1;
    }
}