// Time Complexity : O(log(min(n1, n2))) because we perform Binary Search on the smaller array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// We use Binary Search on the smaller array to find a valid partition of the combined sorted arrays.
// A partition is valid when all elements on the left side are less than or equal to all elements on the right side.
// Once the partition is found, the median is computed using the boundary elements around the partition.

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        // always binary search on smaller array
        if(n1 > n2) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int low = 0;
        int high = n1;

        while(low <= high) {
            int partX = low + (high - low) / 2;
            int partY = (n1 + n2) / 2 - partX;

            // partition boundaries
            double L1 = partX == 0 ? Integer.MIN_VALUE : nums1[partX - 1];
            double R1 = partX == n1 ? Integer.MAX_VALUE : nums1[partX];
            double L2 = partY == 0 ? Integer.MIN_VALUE : nums2[partY - 1];
            double R2 = partY == n2 ? Integer.MAX_VALUE : nums2[partY];

            // valid partition found
            if(L1 <= R2 && L2 <= R1) {
                if((n1 + n2) % 2 == 0) {
                    return (Math.min(R1, R2) + Math.max(L1, L2)) / 2.0;
                } else {
                    return Math.min(R1, R2);
                }
            }

            // move partition right
            else if(L2 > R1) {
                low = partX + 1;
            }

            // move partition left
            else {
                high = partX - 1;
            }
        }

        return 0.0;
    }
}