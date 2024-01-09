// Time complexity : O(log(n1)) , n1 -> size of smaller array
// Space complexity : O(1)
public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = { 1, 5, 9, 10, 15 };
        int[] nums2 = { 2, 11, 12, 13, 14, 16 };
        double median = findMedianSortedArrays(nums1, nums2);
        System.out.println(median);

    }

    private static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0 && nums2.length == 0)
            return 0.0;
        int n1 = nums1.length;
        int n2 = nums2.length;
        if (n1 > n2)
            return findMedianSortedArrays(nums2, nums1);
        int low = 0;
        int high = n1;
        while (low <= high) {
            int partX = low + (high - low) / 2;
            int partY = (n1 + n2) / 2 - partX;
            int l1 = partX == 0 ? Integer.MIN_VALUE : nums1[partX - 1];
            int r1 = partX == n1 ? Integer.MAX_VALUE : nums1[partX];
            int l2 = partY == 0 ? Integer.MIN_VALUE : nums1[partY - 1];
            int r2 = partY == n2 ? Integer.MAX_VALUE : nums1[partY];

            if (l1 <= r2 && l2 <= r1) {
                if ((n1 + n2) % 2 == 0) {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2;
                } else {
                    return Math.min(r1, r2);
                }
            } else if (l2 > r1) {
                low = partX + 1;
            } else if (l1 > r2) {
                high = partY - 1;
            }
        }
        return 0.0;
    }
}
