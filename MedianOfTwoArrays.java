// Approach : 
// Time : O(logn) # whichever nums is lesser in size
// Space: 
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        if (n1 > n2) {
            return findMedianSortedArrays(nums2, nums1);
        }

        // on smaller array
        int low = 0;
        int high = n1; // pointer on partition

        while (low <= high) {
            int partX = low + (high - low) / 2;
            int partY = (n1 + n2 + 1) / 2 - partX;

            // l1,r1,l2,r2 are actual numbers
            double l1 = partX == 0 ? Integer.MIN_VALUE : nums1[partX - 1]; // check if partX is at zero
            double r1 = partX == n1 ? Integer.MAX_VALUE : nums1[partX];
            double l2 = partY == 0 ? Integer.MIN_VALUE : nums2[partY - 1];
            double r2 = partY == n2 ? Integer.MAX_VALUE : nums2[partY];

            if (l1 <=r2 && l2 <=r1) {
                // Even/odd length of combined arrays
                if ((n1 + n2)% 2 == 0) {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2;
                } else {
                    return Math.max(l1, l2);
                }
            } else if (l2 > r1) {
                low = partX + 1;
            } else {
                high = partX - 1;
            }
        }
        return -1;
    }
}