# Time Complexity : O(mlogn + nlogm)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
from typing import List
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        if not nums1 or not nums2:
            return []
        
        result = []
        nums1.sort()
        nums2.sort()
        top = 0
        bottom = 0

        while top<len(nums1) and bottom<len(nums2):
            if nums1[top] == nums2[bottom]:
                result.append(nums1[top])
                top+=1
                bottom+=1
            elif nums1[top]<nums2[bottom]:
                top+=1
            else:
                bottom+=1
        
        return result
    