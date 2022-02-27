"""
Given two integer arrays nums1 and nums2, return an array of their intersection. 
Each element in the result must appear as many times as it shows 
in both arrays and you may return the result in any order.

"""

# Time Complexity : O(n log n + m log m + n log m)
# Space Complexity : O(1)
# Did this code successfully run on leetcode : Yes
# Any problem you faced while coding this : No

from typing import List

class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        
        if nums1 is None or nums2 is None or len(nums1) == 0 or len(nums2) == 0:
            return []

        result = []

        if len(nums1) < len(nums2):
            self.intersect(nums2, nums1)

        nums1.sort()
        nums2.sort()

        # Binary search if both array are sorted.

        low = 0
        high = len(nums1) - 1

        for num in nums2:
            index = self.binarySearch(num, low, high, nums1)
            if index != -1:
                result.append(num)
                low = index + 1

        return result

    def binarySearch(self, num, low, high, num1):

        while low <= high:
            mid = int(low + (high - low) / 2)

            if num1[mid] == num:
                if mid == low or num1[mid - 1] < num1[mid]:
                    return mid
                else:
                    high = mid - 1

            elif num1[mid] > num:
                high = mid - 1
            else:
                low = mid + 1

        return -1
        