"""
Leetcode: https://leetcode.com/problems/median-of-two-sorted-arrays/
Approach:
    1. Perform Binary Search on a smaller array (else flip to have num1 as always smaller)
    2. Partition smaller array at mid
    3. Partition the bigger array such that number of elements on left side of partition is always equal to or
        one more than the elements on right side of partition
    4. Now when we have equal numbers we check the elements in between to see if they form a median
    (by checking if they are all in increasing sequence)
    5. If both left sides are smaller than both right sides then median lies at this point, calculate based on even/odd and return
    6. Else, change the cutA for nums1: if left max of nums1 is greater than right min of nums2,
    then cut should move towards left side of cutA else vice versa.

Time Complexity: O(log(min(m,n))) for binary search on smaller array of size m
Space Complexity: O(1), we only used pointers
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""


class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        aLen = len(nums1)
        bLen = len(nums2)

        # swap nums2 and nums1 if nums 1 is greater than nums2
        if aLen > bLen:
            return self.findMedianSortedArrays(nums2, nums1)

        # take a smaller array
        left = 0
        right = aLen

        # perform binary search on a smaller array
        while left <= right:
            # finding mid
            cutA = left + (right - left) // 2
            # this formula works for both odd and even total length as 12/2 or 13/2 gives 6 in int division
            cutB = (aLen + bLen + 1) // 2 - cutA

            if cutA == 0:
                maxLeftA = float('-inf')
            else:
                maxLeftA = nums1[cutA - 1]

            if cutA == aLen:
                minRightA = float('inf')
            else:
                minRightA = nums1[cutA]

            if cutB == 0:
                maxLeftB = float('-inf')
            else:
                maxLeftB = nums2[cutB - 1]

            if cutB == bLen:
                minRightB = float('inf')
            else:
                minRightB = nums2[cutB]

            # Check whether we find the correct partition
            if maxLeftA <= minRightB and maxLeftB <= minRightA:
                if (aLen + bLen) % 2 == 0:
                    return (max(maxLeftA, maxLeftB) + min(minRightA, minRightB)) / 2.0
                else:
                    return max(maxLeftA, maxLeftB)
            elif maxLeftA > minRightB:
                right = cutA - 1
            else:  # maxLeftB > minRightA
                left = cutA + 1
        return 0.0