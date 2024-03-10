# https://leetcode.com/problems/intersection-of-two-arrays-ii/

# Time Complexity : O(N * Log(N)) where N is length of the largest input array.
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Yes.


# Your code here along with comments explaining your approach

# Approach : We first sort the arrays. Now we start smaller array and start searching the larger array.
# We keep finding the target. However, there is a edge case here, we have to find the first occurrence of the
# target and keep moving the low. So that we don't return wrong results.

from typing import List


class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        if len(nums1) > len(nums2):
            return self.intersect(nums2, nums1)
        nums1.sort()
        nums2.sort()
        # nums1 is shorter than nums2
        low, high = 0, len(nums2) - 1
        result = []
        for cur in nums1:
            cur_index = self.binarysearch(nums2, low, high, cur)
            if cur_index != -1:
                low = cur_index + 1
                result.append(cur)
        return result

    def binarysearch(self, nums, low, high, target):
        while low <= high:
            mid = low + (high - low) // 2
            if nums[mid] == target:
                if mid == low or nums[mid] > nums[mid - 1]:
                    return mid
                else:
                    high = mid - 1
            elif nums[mid] < target:
                low = mid + 1
            else:
                high = mid - 1
        return -1
