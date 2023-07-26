// Time Complexity : O(log(min(N, M)))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

#include <iostream>
#include <vector>
#include <algorithm> // for min and max functions

double findMedianSortedArrays(std::vector<int>& x, std::vector<int>& y) {
    int xLen = x.size();
    int yLen = y.size();

    if (xLen > yLen) {
        // Swap x and y so that x is the shorter one
        return findMedianSortedArrays(y, x);
    }

    int left = 0, right = xLen; // set limits for left and right
    int partitionX, partitionY; // corresponding indices for partition
    int maxLeftX, minRightX; // max element in X on left side and min element on right side of partition
    int maxLeftY, minRightY; // max element in Y on left side and min element on right side of partition

    while (left <= right) { // standard binary search
        partitionX = (left + right) / 2;
        partitionY = (xLen + yLen + 1) / 2 - partitionX;

        maxLeftX = (partitionX == 0) ? INT_MIN : x[partitionX - 1];
        minRightX = (partitionX == xLen) ? INT_MAX : x[partitionX];
        maxLeftY = (partitionY == 0) ? INT_MIN : y[partitionY - 1];
        minRightY = (partitionY == yLen) ? INT_MAX : y[partitionY];

        if (maxLeftX <= minRightY && maxLeftY <= minRightX) { // correct partition found!
            if ((xLen + yLen) % 2 == 0) { // even case
                return (std::max(maxLeftX, maxLeftY) + std::min(minRightX, minRightY)) / 2.0;
            } else {
                return std::max(maxLeftX, maxLeftY);
            }
        } else if (maxLeftX > minRightY) { // reduce bounds
            right = partitionX - 1;
        } else {
            left = partitionX + 1;
        }
    }

    return 0.0;
}