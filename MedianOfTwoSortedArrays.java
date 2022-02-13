//  Time Complexity: O(log(min(n1, n2))
//  Space Complexity: O(1)

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if (nums1.length > nums2.length)
            return findMedianSortedArrays(nums2, nums1);

        int n1 = nums1.length;
        int n2 = nums2.length;

        int low = 0;
        int high = n1;

        while (low <= high) {
            int partition1 = low + (high - low) / 2;
            int partition2 = (n1 + n2) / 2 - partition1;

            int left1 = partition1 == 0 ? Integer.MIN_VALUE : nums1[partition1 - 1];
            int left2 = partition2 == 0 ? Integer.MIN_VALUE : nums2[partition2 - 1];

            int right1 = partition1 == n1 ? Integer.MAX_VALUE : nums1[partition1];
            int right2 = partition2 == n2 ? Integer.MAX_VALUE : nums2[partition2];

            if (left1 <= right2 && left2 <= right1) {
                //  found the correct partition
                //  check for even or odd number of elements
                if ((n1 + n2) % 2 == 0) {
                    return (double) (Math.max(left1, left2) + Math.min(right1, right2)) / 2;
                }
                else {
                    return (double) Math.min(right1, right2);
                }
            }
            else if (left1 > right2) {
                high = partition1 - 1;
            }
            else {
                low = partition1 + 1;
            }
        }

        return 0.0;
    }
}
