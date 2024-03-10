// Time Complexity: O(log(n)) where n = length of smaller array
// Space complexity: O(1)

// Approach: Median will always have equal elements on left and right
// and the largest element on left will be smaller than smallest element on the right

class MedianOfSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // always making sure n1 is smaller
        if (nums2.length < nums1.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        // positions of partitions
        int low = 0;
        int high = nums1.length;

        while (low <= high) {
            int partX = low + (high - low) / 2;
            int partY = ((nums1.length + nums2.length) / 2) - partX;
            int l1 = partX == 0 ? Integer.MIN_VALUE : nums1[partX - 1];
            int l2 = partY == 0 ? Integer.MIN_VALUE : nums2[partY - 1];

            int r1 = partX == nums1.length ? Integer.MAX_VALUE : nums1[partX];
            int r2 = partY == nums2.length ? Integer.MAX_VALUE : nums2[partY];

            if (l1 <= r2 && l2 <= r1) {
                if ((nums1.length + nums2.length) % 2 == 0) {
                    return (Math.min(r1, r2) + Math.max(l1, l2)) / 2.0;
                } else {
                    return (double) Math.min(r1, r2);
                }
            } else if (l1 > r2) {
                high = partX - 1;
            } else {
                low = partX + 1;
            }
        }

        // code will never reach here
        return 2.0;
    }
}