// Time Complexity : O(log(min{m, n})
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
The idea is to do binary search on smaller array by making a partition initially at mid element and use the
formula to compute the partitionY for second array.Now, we calculate 4 pointers near to the partitions as most
likely the median is going to lay there.We have to make sure left side mins are always less than the right side
maxs' and adjust the low, high positions accordingly. If the criteria is met, it means we have the median ready
and if its an even length of combined array, then we take the max of lefts and min of rights average, if not,
it means the median lies somewhere towards the right end, so take the max of rights.
 */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        if(nums1.length > nums2.length)
            return findMedianSortedArrays(nums2, nums1);

        int low = 0, high = n1;

        while(low <= high) {
            int partX = low + (high - low) / 2;
            int partY = (n1 + n2) / 2 - partX;

            double L1 = partX == 0 ? Integer.MIN_VALUE : nums1[partX - 1];
            double R1 = partX == n1 ? Integer.MAX_VALUE : nums1[partX];
            double L2 = partY == 0 ? Integer.MIN_VALUE : nums2[partY - 1];
            double R2 = partY == n2 ? Integer.MAX_VALUE : nums2[partY];

            if(L1 <= R2 && L2 <= R1) {
                if((n1 + n2) % 2 == 0)
                    return (Math.min(R1 , R2) + Math.max(L1, L2)) / 2;
                else
                    return Math.min(R1, R2);
            }
            else if(L1 > R2)
                high = partX - 1;
            else
                low = partX + 1;
        }
        return -1;
    }
}