public class MedianTwoSortedArrays {

    /*
    TC : log(N) where N is the length of the shorter array
    SC : O(1)
    LC: yes
    Problems : No
     */

    /**
     * Here we use the partition concept and use binary search approach to find the partition for both arrays
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if (n1 > n2)
            return findMedianSortedArrays(nums2, nums1);
        int low = 0;
        int high = n1;
        while (low <= high) {
            int partX = low + (high - low) / 2;
            int partY = (n1 + n2) / 2 - partX;

            double L1 = partX == 0 ? Integer.MIN_VALUE : nums1[partX - 1];
            double L2 = partY == 0 ? Integer.MIN_VALUE : nums2[partY - 1];
            double R1 = partX == n1 ? Integer.MAX_VALUE : nums1[partX];
            double R2 = partY == n2 ? Integer.MAX_VALUE : nums2[partY];

            if (L1 <= R2 && L2 <= R1) {
                if ((n1 + n2) % 2 == 0) {
                    return (Math.max(L1, L2) + Math.min(R1, R2)) / 2;
                } else
                    return Math.min(R1, R2);
            } else if (L1 > R2)
                high = partX - 1;
            else if (L2 > R1)
                low = partX + 1;


        }

        return 0;
    }
}
