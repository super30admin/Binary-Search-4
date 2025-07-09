# Time Complexity : O(log(min(m, n))), where m and n are the lengths of the two arrays
# Space Complexity : O(1), constant space used
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Understanding partitioning logic was a bit tricky at first

# I used a binary search on the smaller array to find the correct partition.
# I ensured that elements on the left of the partition are less than or equal to elements on the right.
# Depending on the total length (even/odd), I calculated the median using the max of left and min of right.

from typing import List

class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        # Always binary search on the smaller array
        if len(nums1) > len(nums2):
            nums1, nums2 = nums2, nums1

        m, n = len(nums1), len(nums2)
        low, high = 0, m

        while low <= high:
            partitionX = (low + high) // 2
            partitionY = (m + n + 1) // 2 - partitionX

            maxLeftX = float('-inf') if partitionX == 0 else nums1[partitionX - 1]
            minRightX = float('inf') if partitionX == m else nums1[partitionX]

            maxLeftY = float('-inf') if partitionY == 0 else nums2[partitionY - 1]
            minRightY = float('inf') if partitionY == n else nums2[partitionY]

            if maxLeftX <= minRightY and maxLeftY <= minRightX:
                if (m + n) % 2 == 0:
                    return (max(maxLeftX, maxLeftY) + min(minRightX, minRightY)) / 2
                else:
                    return max(maxLeftX, maxLeftY)
            elif maxLeftX > minRightY:
                high = partitionX - 1
            else:
                low = partitionX + 1

        # If input is invalid
        return 0.0
