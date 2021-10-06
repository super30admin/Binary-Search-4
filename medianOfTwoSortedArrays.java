public class medianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // TC : O(log(m+n))
        int n1 = nums1.length;
        int n2 = nums2.length;
        if (n1 > n2)
            return findMedianSortedArrays(nums2, nums1);

        // Partionning logic starts
        int low = 0, high = n1;
        while (low <= high) {
            int partX = low + (high - low) / 2;
            int partY = (n1 + n2 + 1) / 2 - partX;
            // If extreme left partition before 0th index then take -infinity or else take
            // nums1[partX-1]
            double l1 = partX == 0 ? Integer.MIN_VALUE : nums1[partX - 1];
            double R1 = partX == n1 ? Integer.MAX_VALUE : nums1[partX];

            double l2 = partY == 0 ? Integer.MIN_VALUE : nums2[partY - 1];
            double R2 = partY == n2 ? Integer.MAX_VALUE : nums2[partY];

            if (l1 <= R2 && l2 <= R1) { // correct partition; satisfies
                if ((n1 + n2) % 2 == 0) {
                    return (Math.max(l1, l2) + Math.min(R1, R2)) / 2;
                } else
                    return Math.max(l1, l2);
            } else if (l2 > R1)
                low = partX + 1;
            else
                high = partX - 1;
        }
        return -1;
    }
}
