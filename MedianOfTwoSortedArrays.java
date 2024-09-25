public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null && nums2 == null) {
            return -1.0;
        }
        // find the length of both arrays
        int m = nums1.length;
        int n = nums2.length;
        // if first array is larger than the second we
        // call the function again by interchanging the arrays
        // Doing this because we are always performing binary searchon first array which
        // is smaller.
        if (m > n) {
            return findMedianSortedArrays(nums2, nums1);
        }
        // high is m but not m-1 because we are doing partition on element not the
        // index.
        int low = 0;
        int high = m;
        // start binary search.
        while (low <= high) {
            int partx = low + (high - low) / 2; // prevent integer overflow
            int party = (m + n) / 2 - partx;
            double l1 = partx == 0 ? Integer.MIN_VALUE : nums1[partx - 1];
            double r1 = partx == m ? Integer.MAX_VALUE : nums1[partx];
            double l2 = party == 0 ? Integer.MIN_VALUE : nums2[party - 1];
            double r2 = party == n ? Integer.MAX_VALUE : nums2[party];
            if (l1 <= r2 && l2 <= r1) {
                if ((m + n) % 2 == 0) {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2;
                }
                return Math.min(r1, r2);
            } else if (l1 > r2) {
                high = partx - 1;
            } else if (l2 > r1) {
                low = partx + 1;
            }
        }
        return -1.0;

    }
}
