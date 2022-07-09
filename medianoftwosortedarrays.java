//Time  : O(log(n1))
//Space :O(1)

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if (n1 > n2)
            return findMedianSortedArrays(nums2, nums1);
        int low = 0;
        int high = n1;
        while (low <= high) {
            int xp = low + (high - low) / 2;
            int yp = (n1 + n2) / 2 - xp;
            double l1 = xp == 0 ? Integer.MIN_VALUE : nums1[xp - 1];
            double l2 = yp == 0 ? Integer.MIN_VALUE : nums2[yp - 1];
            double r1 = xp == n1 ? Integer.MAX_VALUE : nums1[xp];
            double r2 = yp == n2 ? Integer.MAX_VALUE : nums2[yp];
            if (l2 > r1) {
                low = xp + 1;
            } else if (l1 > r2) {
                high = xp - 1;
            } else if (l1 <= r2 && l2 <= r1) {
                if ((n1 + n2) % 2 == 0) {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2;
                } else {
                    return Math.min(r1, r2);
                }
            }

        }

        return 9.99;
    }
}
