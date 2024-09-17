'''
Time Complexity:  O(log (m+n))
Space Complexity: O(1)
Did this code successfully run on Leetcode : Yes
Explanation: Use Binary search to find the median, create a partition first which is the middle of the list1 and then
use the first partition - length of both lists to find partition of second. After finding both partitions use the condition
maxLeftX <= minRightY and maxLeftY <= minRightX to check if we are in the correct median range. If yes and the length
of X and Y are even then return return (max(maxLeftX, maxLeftY) + min(minRightX, minRightY)) / 2 else return
(max(maxLeftX, maxLeftY))

If we haven't reached the partition area move the right pointer by partitionX-1 if maxLeftX > minRightY else if
maxLeftY > minRightX then set left = partitionX + 1
'''

import math


class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        lenX = len(nums1)
        lenY = len(nums2)

        if lenX > lenY:
            return self.findMedianSortedArrays(nums2, nums1)

        left = 0
        right = lenX

        while left <= right:
            partitionX = int((left + right) / 2)
            partitionY = int((lenX + lenY + 1) / 2 - partitionX)
            if partitionX == 0:
                maxLeftX = -math.inf
            else:
                maxLeftX = nums1[partitionX - 1]

            if partitionX == lenX:
                minRightX = math.inf
            else:
                minRightX = nums1[partitionX]

            if partitionY == 0:
                maxLeftY = -math.inf
            else:
                maxLeftY = nums2[partitionY - 1]

            if partitionY == lenY:
                minRightY = math.inf
            else:
                minRightY = nums2[partitionY]

            if maxLeftX <= minRightY and maxLeftY <= minRightX:
                if (lenX + lenY) % 2 == 0:
                    return (max(maxLeftX, maxLeftY) + min(minRightX, minRightY)) / 2
                else:
                    return (max(maxLeftX, maxLeftY))
            elif maxLeftX > minRightY:
                right = partitionX - 1
            else:
                left = partitionX + 1

        return 0.0