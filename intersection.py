# Time Complexity : O(nlogm) where n is length of smaller array
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

from math import floor
from typing import List


class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:

        if len(nums1) == 0 or len(nums2) == 0:
            return []
        # given two arrays
        n1 = len(nums1)
        n2 = len(nums2)
        # to store the final result
        result = []

        #
        if n1 > n2:
            return self.intersect(nums2, nums1)

        # sorting the array2
        nums2.sort()

        for x in nums1:

            # setting low and high pointers
            low = 0  # on n1
            high = len(nums2) - 1  # on n2

            while low <= high:
                mid = floor((low + high)/2)

                if nums2[mid] == x:
                    result.append(x)
                    del nums2[mid]
                    break

                elif nums2[mid] < x:
                    low = mid + 1

                else:
                    high = mid - 1

        return result
