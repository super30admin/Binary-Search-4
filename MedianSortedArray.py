"""
Given two sorted arrays nums1 and nums2 of size m and n respectively, 
return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).

"""

# Time Complexity : O(log m + log n)
# Space Complexity : O(1)
# Did this code successfully run on leetcode : Yes
# Any problem you faced while coding this : No

from typing import List

class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
                
        if len(nums1) == 0 and len(nums2) == 0:
            return 0

        n1 = len(nums1)
        n2 = len(nums2)

        if n1 > n2:
            return self.findMedianSortedArrays(nums2,nums1)

        low = 0
        high = n1

        while low <= high:
            p1 = int(low +(high-low)/2)
            p2 = int((n1+n2)/2 - p1)
            print(p1,p2)

            l1 = float('-inf') if p1 == 0 else nums1[p1-1]
            r1 = float('inf') if p1 == n1 else nums1[p1]
            l2 = float('-inf') if p2 == 0 else nums2[p2-1]
            r2 = float('inf') if p2 == n2 else nums2[p2]
            if l1 <= r2 and l2 <= r1:
                if (n1 + n2) % 2 == 1:
                    return min(r2,r1)
                else:
                    return (min(r2,r1) + max(l1,l2))/2

            elif l1 > r2:
                high = p1 -1
            else:
                low = p1 + 1 


            
            