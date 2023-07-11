public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0 && nums2.length == 0)
            return 0.0;
        int n1 = nums1.length, n2 = nums2.length;

        if (n1 > n2)
            return findMedianSortedArrays(nums2, nums1);
        int low = 0, high = n1;

        while (low <= high) {
            int partX = low + (high - low) / 2;
            int partY = (n1 + n2) / 2 - partX;

            double L1 = partX == 0 ? Integer.MIN_VALUE : nums1[partX - 1];
            double R1 = partX == n1 ? Integer.MAX_VALUE : nums1[partX];

            double L2 = partY == 0 ? Integer.MIN_VALUE : nums2[partY - 1];
            double R2 = partY == n2 ? Integer.MAX_VALUE : nums2[partY];

            if (L1 <= R2 && L2 <= R1) {
                if ((n1 + n2) % 2 == 0) {
                    return (Math.max(L1, L2) + Math.min(R1, R2)) / 2;
                } else {
                    return Math.min(R1, R2);
                }
            } else if (L2 > R1) {
                low = partX + 1;
            } else {
                high = partX - 1;
            }
        }
        return 128.1287123;
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArrays solution = new MedianOfTwoSortedArrays();

        // int[] nums1 = { 1, 3 };
        // int[] nums2 = { 2 };
        int[] nums1 = { 1, 5, 9, 10, 15 };
        int[] nums2 = { 2, 11, 13, 14, 15, 16 };

        double median = solution.findMedianSortedArrays(nums1, nums2);

        System.out.println("Median of Two Sorted Arrays: " + median);
    }
}
