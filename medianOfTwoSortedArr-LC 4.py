# Binary search Solution
# Time Complexity = O(log m), doing binary search only in smaller arr of len m
# Space Complexity = O(1)

import math

class Solution:
    def findMedianSortedArrays(self, nums1: list[int], nums2: list[int]) -> float:
        if (nums1 == None and nums2 == None) or (len(nums1) == 0 and len(nums2) == 0):
            return 0.0
        
        m = len(nums1)
        n = len(nums2)
        if n < m:
            return self.findMedianSortedArrays(nums2, nums1)
        
        
        low = 0
        high = m            # partitions of array = len of array
        
        
        while(low <= high):
            partX = low + (high - low) // 2
            partY = (m + n) // 2 - partX
            
            l1 = -math.inf if partX == 0 else nums1[partX - 1]         # partX is the partition, element at that partition will be index of partX - 1
            l2 = -math.inf if partY == 0 else nums2[partY - 1]
            r1 = math.inf if partX == m else nums1[partX]
            r2 = math.inf if partY == n else nums2[partY]
            
            # Conditions for valid partition:
            # l1 <= r1  always true (same array, in ascending order)
            # l2 <= r2  always true
            if l1 <= r2 and l2 <= r1:       # Valid partition
                if (m + n) % 2 == 0:
                    return (max(l1, l2) + min(r1, r2)) / 2
                return min(r1, r2)
            
            elif l1 > r2:           # Move left to find a smaller element
                high = partX - 1
            
            else:                   # Move right to find a larger element
                low = partX + 1
                
                
        return 0.0

            