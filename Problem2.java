// Time complexity: O(log (smaller array size))
// Space complexity: O(1)

//Accepted on leetcode

// Approach
// Instead of using numbers -> use partitions to check if we are in the correct position, use shorter array as start and end, for each mid calculated place partitions in arr1 and arr2 such that we divide array in two parts
// If correctly partitioned -> left side all elems <= right side all elems (we are partitioning in sorted order)
// Check border elems to figure if partition is correct -> if partition correct, we use border elems (which we know are middle elems in sorted order) to get the median



class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        if (m + n == 0) {
            return 0.0;
        } 

        /* Assuming nums 1 is always the smaller of the two */
        if (m > n) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int low = 0;
        int high = m;

        while (low <= high) {
            int mid = low + (high - low)/2;
            int partX = mid;
            int partY = (m + n)/2 - partX;

            double l1 = partX == 0 ? Integer.MIN_VALUE : nums1[partX - 1];
            double l2 = partY == 0 ? Integer.MIN_VALUE : nums2[partY - 1];
            double r1 = partX == nums1.length ? Integer.MAX_VALUE: nums1[partX];
            double r2 = partY == nums2.length ? Integer.MAX_VALUE: nums2[partY];

            /* If found */
            if (l1 <= r2 && l2 <= r1) { 
                if ( (m + n)%2 == 0) /* Even count of total elems */ {
                    return (Math.max(l1,l2) + Math.min(r1,r2))/2.0;
                } else /* Odd count of total elems */ {
                    return Math.min(r1, r2);
                }
            } else { /* If not found */
                if (l1 > r2) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }

        return 0.0;
    }
}
