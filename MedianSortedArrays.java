/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * 
 * Find the median of the two sorted arrays. The overall run time complexity
 * should be O(log (m+n)).
 * 
 * You may assume nums1 and nums2 cannot be both empty.
 * 
 * Idea: Use binary search for finding correct parition.
 * 
 *  x1 x2 x3 | x4 x5 x6                 
 *  y1 y2 y3 y4 | y5 y6 y7 y8
 * 
 * correct partition would be such that
 * x3 <= y5 and y4 <= x4
 * 
 * Time Complexity O(log(min(m,n)))
 * Space Complexity O(1), constant extra space
 * 
 * Leetcode Result:
 * Runtime: 2 ms, faster than 99.99% of Java online submissions for Median of Two Sorted Arrays.
 * Memory Usage: 46.4 MB, less than 91.67% of Java online submissions for Median of Two Sorted Arrays.
 */
class Solution {
    public double findMedianSortedArrays(int[] x, int[] y) {
        int xLen = x.length, yLen = y.length;
        if (xLen > yLen) {
            // we want x to be the shorter one
            return findMedianSortedArrays(y, x);
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
            } else {
                maxLeftX = x[partitionX - 1];
            }

            if (partitionX == xLen) {
                minRightX = Integer.MAX_VALUE;
            } else {
                minRightX = x[partitionX];
            }

            if (partitionY == 0) {
                maxLeftY = Integer.MIN_VALUE;
            } else {
                maxLeftY = y[partitionY - 1];
            }

            if (partitionY == yLen) {
                minRightY = Integer.MAX_VALUE;
            } else {
                minRightY = y[partitionY];
            }

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) { // correct partition found!
                if ((xLen + yLen) % 2 == 0) { // even case
                    return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2.0;
                } else {
                    return Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) { // reduce bounds
                right = partitionX - 1;
            } else {
                left = partitionX + 1;
            }
        }
        return 0.0;
    }
}