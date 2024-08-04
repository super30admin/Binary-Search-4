// Time Complexity: O(log (m + n))
// Space Complexity: O(1)

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length)
            return findMedianSortedArrays(nums2, nums1);

        int n1 = nums1.length, n2 = nums2.length;
        int low = 0, high = n1;
        while (low <= high) {
            int partx = low + (high - low) / 2;
            int party = (n1 + n2) / 2 - partx;
            int l1 = partx == 0 ? Integer.MIN_VALUE : nums1[partx - 1];
            int l2 = party == 0 ? Integer.MIN_VALUE : nums2[party - 1];
            int r1 = partx == n1 ? Integer.MAX_VALUE : nums1[partx];
            int r2 = party == n2 ? Integer.MAX_VALUE : nums2[party];

            if (l1 <= r2 && l2 <= r1) {
                // good partitiion
                if ((n1 + n2) % 2 == 1)
                    return Math.min(r1, r2);
                else
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
            } else if (l1 > r2)
                high = partx - 1;

            else
                low = partx + 1;
        }

        return 10032.9213;

    }
}