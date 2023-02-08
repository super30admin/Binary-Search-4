// 4. Median of Two Sorted Arrays
// Time Complexity : O(log m) where m is min size between nums1 & nums2
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Approach
// for this problem, we will apply partition concept. Also, will apply BinarySearch on the partition not on the numbers.
// for odd number of elements, the result is maximum L1 & L2 (left partition of nums1 & nums2)
// for even number of elements, the result is half of, addition of (maximum L1 & L2) & (minimum of R1 & R2; which is right partition of nums1 & nums2)
// In (x1 x2 x3 | x4 x5 x6) & (y1 y2 y3 y4 | y5 y6 y7 y8), correct partition would be (x3 <= y5 and y4 <= x4)


class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int xLen = nums1.length, yLen = nums2.length;
        if (xLen > yLen) {
            // we want x to be the shorter one
            return findMedianSortedArrays(nums2, nums1);
        }

        int left = 0, right = xLen; // set limits for left and right
        int partitionX, partitionY; // corresponding indices for partition
        int maxLeftX; // max element in X on left side of partition
        int minRightX; // min element in X on right side of partition
        int maxLeftY; // max element in Y on left side of partition
        int minRightY; // min element in Y on righ side of partition

        while (left <= right) { // standard binary search
            partitionX = (left + right) / 2;
            partitionY = (xLen + yLen + 1) / 2 - partitionX;

            if (partitionX == 0) {
                maxLeftX = Integer.MIN_VALUE;
            }
            else {
                maxLeftX = nums1[partitionX - 1];
            }

            if (partitionX == xLen) {
                minRightX = Integer.MAX_VALUE;
            }
            else {
                minRightX = nums1[partitionX];
            }

            if (partitionY == 0) {
                maxLeftY = Integer.MIN_VALUE;
            }
            else {
                maxLeftY = nums2[partitionY - 1];
            }

            if (partitionY == yLen) {
                minRightY = Integer.MAX_VALUE;
            }
            else {
                minRightY = nums2[partitionY];
            }

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) { // correct partition found!
                if ((xLen + yLen) % 2 == 0) { // even case
                    return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2.0;
                }
                else { // odd case
                    return Math.max(maxLeftX, maxLeftY);
                }

            }
            else if (maxLeftX > minRightY) { // reduce bounds
                right = partitionX - 1;
            }
            else {
                left = partitionX + 1;
            }
        }
        return 0.0;
    }
}
