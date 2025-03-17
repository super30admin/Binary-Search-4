// Time Complexity : O(log m)
// Space Complexity : O(1).
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        if(m > n) return findMedianSortedArrays(nums2, nums1);

        int start = 0;
        int end = m;
        while(start <= end)
        {
            int partx = start + (end-start)/2;
            int party = (m+n)/2 - partx;

            int L1 = partx == 0 ? Integer.MIN_VALUE : nums1[partx-1];
            int L2 = party == 0 ? Integer.MIN_VALUE : nums2[party-1];
            int R1 = partx == m ? Integer.MAX_VALUE : nums1[partx];
            int R2 = party == n ? Integer.MAX_VALUE : nums2[party];

            if(L1 <= R2 && L2 <= R1)
            {
                if((m+n)%2 == 0)
                    return (Math.max(L1, L2) + Math.min(R1, R2))/2.0;
                else
                    return Math.min(R1, R2);
            }
            else if(L1 > R2)
                end = partx-1;
            else
                start = partx+1;

        }
        return -1;
    }
}