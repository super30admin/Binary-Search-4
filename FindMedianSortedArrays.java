// Time Complexity : O(log(m+n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2)
    {
        if(nums1.length > nums2.length)
            return findMedianSortedArrays(nums2, nums1);

        int m = nums1.length;
        int n = nums2.length;
        int low = 0, high = m;

        while(low <= high)
        {
            int partX = low + (high-low)/2;
            int partY = (m + n)/2 - partX;
            int L1 = partX == 0 ? Integer.MIN_VALUE : nums1[partX-1];
            int R1 = partX == m ? Integer.MAX_VALUE : nums1[partX];

            int L2 = partY == 0 ? Integer.MIN_VALUE : nums2[partY-1];
            int R2 = partY == n ? Integer.MAX_VALUE : nums2[partY];

            if(L1 <= R2 && L2 <= R1)
            {
                if((m + n)%2 == 0)
                    return (Math.max(L1, L2) + Math.min(R1, R2))/2.0;
                else
                    return Math.min(R1, R2);
            }
            else if(L2 > R1)
                low = partX + 1;
            else
                high = partX - 1;
        }

        return 9999;
    }
}
