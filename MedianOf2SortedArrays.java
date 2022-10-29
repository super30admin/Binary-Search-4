// Time Complexity: O(logN)
// Space Complexity: O(1)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if ((nums1 == null && nums2 == null) || (nums1.length == 0 && nums2.length == 0)) return 0.0;

        int m = nums1.length;
        int n = nums2.length;

        if (n < m) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int low = 0, high = m;

        while (low <= high) {
            // partX, partY
            int partX = low + (high-low)/2; // prevent integer overflow
            int partY = (m + n) / 2 - partX;
            // calculate L1, L2, R1, R2

            double l1 = partX == 0 ? Integer.MIN_VALUE : nums1[partX-1];
            double l2 = partY == 0 ? Integer.MIN_VALUE : nums2[partY-1];

            double r1 = partX == m ? Integer.MAX_VALUE : nums1[partX];
            double r2 = partY == n ? Integer.MAX_VALUE : nums2[partY];

            if (l1 <= r2 && l2 <= r1) {
                if ((m + n) % 2 == 0) {
                    return (Math.max(l1,l2) + Math.min(r1, r2))/2;
                }
                return Math.min(r1, r2);
            } else if (l2 > r1) {
                low = partX + 1;
            } else {
                high = partX - 1;
            }
        }

        return 0.0;
    }
}
