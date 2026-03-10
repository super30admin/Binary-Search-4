# Time Complexity : O(n log n + m log m), n = len(nums1), m = len(nums2) for sorting
# Space Complexity : O(min(n, m)) for the result array
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Explanation:
# 1. Sort both input arrays to allow linear traversal for intersection.
# 2. Use two pointers i, j to iterate through nums1 and nums2.
# 3. If nums1[i] < nums2[j], increment i; if nums1[i] > nums2[j], increment j.
# 4. If nums1[i] == nums2[j], append to result and increment both pointers.
# 5. Continue until reaching the end of either array.

from typing import List

class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        nums1 = sorted(nums1)
        nums2 = sorted(nums2)
        i = 0
        j = 0
        result = []
        
        while i < len(nums1) and j < len(nums2):
            if nums1[i] < nums2[j]:
                i += 1
            elif nums1[i] > nums2[j]:
                j += 1
            else:
                result.append(nums1[i])
                i += 1
                j += 1
        
        return result