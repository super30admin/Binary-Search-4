// TC: log (min (m, n)) // We need to do binary search on smaller array to reduce the complexity.
// See class video if confused on using partitions and actual logic
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        if (m > n) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int low = 0;
        int high = m; // not m - 1. Since it is partition number and not index.

        // do normal binary search
        while (low <= high) {
            int partX = low + (high - low) / 2; // prevent integer overflow
            int partY = (m + n) / 2 - partX;

            double l1 = partX == 0 ? Integer.MIN_VALUE : nums1[partX - 1]; // element just before the partition
            double l2 = partY == 0 ? Integer.MIN_VALUE : nums2[partY - 1]; // element just after the partition (same as partition value)
            double r1 = partX == m ? Integer.MAX_VALUE : nums1[partX];
            double r2 = partY == n ? Integer.MAX_VALUE : nums2[partY];

            // l1 is naturally <= r1 and l2 is naturally <= r2. But when below condition satisfies, all the elements in both left partition 
            // are lesser than or equal to elements in the right because we are comparing 2 greatest integers in left partition with 2 smallest in right.
            if ((l1 <=r2) && (l2 <= r1)) {
                if ((m + n) % 2 == 0) { // totally even number of elements. median is average of middle 2 elements.
                    return (Math.max(l1, l2) + Math.min(r1, r2) ) / 2.0;
                } else {
                    return Math.min(r1, r2);
                }
            } else if (l1 > r2) {
                high = partX - 1;
            } else {
                low = partX + 1;
            }
        }

        // not expecting code to reach here
        return 0.0;

    }
}