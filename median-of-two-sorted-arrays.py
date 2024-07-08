# Time Complexity : O(m+n)
# Space Complexity : O(m+n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
from typing import List
class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        if nums1 is None or nums2 is None:
            return 0.0
        
        p1 =0
        p2=0
        result = []

        while p1 < len(nums1) and p2 < len(nums2):
            if nums1[p1] < nums2[p2]:
                result.append(nums1[p1])
                p1+=1
            else:
                result.append(nums2[p2])
                p2+=1
        
        if p1 < len(nums1):
            result.extend(nums1[p1:])
        if p2 < len(nums2):
            result.extend(nums2[p2:])
        
        mid = len(result)//2

        if len(result)%2 != 0:
            return result[mid]
        else:
            return (result[mid]+result[mid-1])/2



                


        