# Problem2: Median of Two Sorted Arrays (https://leetcode.com/problems/median-of-two-sorted-arrays)
# TC: O(log(min(m, n))), binary search runs only on the smaller array
# SC: O(1),only a few variables used
# Approach:
# Binary search on the smaller array to find a correct partition (cut) of both arrays.
# A cut is correct when every element on the left side <= every element on the right side.
# Only the 4 elements near the cuts (L1, R1, L2, R2) need to be checked.
# If total length is odd, the median is the max of the left side.
# If total length is even, the median is the average of the left max and the right min.

class Solution:
    def findMedianSortedArrays(self, nums1: list[int], nums2: list[int]) -> float:
        n1 = len(nums1)  # length of first array
        n2 = len(nums2)  # length of second array

        # Make nums1 the smaller array so partY always stays in range
        if n1 > n2:
            return self.findMedianSortedArrays(nums2, nums1)

        low = 0    # smallest possible cut in nums1 (take nothing)
        high = n1  # largest possible cut in nums1 (take everything)

        while low <= high:
            # partX = number of elements taken from nums1 into the left half
            partX = low + (high - low) // 2
            # partY = elements needed from nums2 so left half has (total+1)//2 elements
            partY = ((n1 + n2 + 1) // 2) - partX

            # Border elements around the cuts (use -inf / +inf when a side is empty)
            L1 = float('-inf') if partX == 0 else nums1[partX - 1]   # last on left of nums1
            R1 = float('inf') if partX == n1 else nums1[partX]       # first on right of nums1
            L2 = float('-inf') if partY == 0 else nums2[partY - 1]   # last on left of nums2
            R2 = float('inf') if partY == n2 else nums2[partY]       # first on right of nums2

            # Correct partition: left side elements <= right side elements across arrays
            if L1 <= R2 and L2 <= R1:
                if (n1 + n2) % 2 == 0:
                    # Even total: average of left max and right min
                    return (max(L1, L2) + min(R1, R2)) / 2.0
                else:
                    # Odd total: left half holds the extra element, so median is left max
                    return max(L1, L2)
            elif L2 > R1:
                # nums2's left side is too big, take more from nums1 (move cut right)
                low = partX + 1
            else:
                # L1 > R2: nums1's left side is too big, take fewer from nums1 (move cut left)
                high = partX - 1

        return -1  # never reached for valid input