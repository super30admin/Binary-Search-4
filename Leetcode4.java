class Solution {
    // Solution - Binary Search on finding out the partition
    // TC - O(log(m))
    // SC - O(1)
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int small = nums1.length;
        int big = nums2.length;

        if (small > big) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int low = 0;
        int high = small;

        while (low <= high) {

            int partitionX = low + (high - low) / 2;
            int partitionY = (small + big) / 2 - partitionX;

            int left1 = partitionX == 0 ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int left2 = partitionY == 0 ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int right1 = partitionX == small ? Integer.MAX_VALUE : nums1[partitionX];
            ;
            int right2 = partitionY == big ? Integer.MAX_VALUE : nums2[partitionY];

            if (left1 <= right2 && left2 <= right1) {
                if ((small + big) % 2 == 0) {
                    return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;

                } else {
                    return Math.min(right1, right2);
                }
            } else if (left2 > right1) {
                low = partitionX + 1;

            } else {
                high = partitionX - 1;
            }
        }
        return 0.0;

    }
}