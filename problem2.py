#Time Complexity :  O(log (m+n))
#Space Complexity :O(1)
#Did this code successfully run on Leetcode : yes

from ast import List


class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        n1 = len(nums1)
        n2 = len(nums2)
        if n1 == 0 and n2 == 0:
            return 0.0

        # If nums1 is greater than nums2 then will swap
        if n1 > n2:
            return self.findMedianSortedArrays(nums2, nums1)
        
        low = 0
        high = n1

        while low <= high:
            partX = low + (high - low) // 2  #partition of nums1
            partY = (n1 + n2) // 2 - partX   #partition of nums2
            l1 = float('-inf') if partX == 0 else nums1[partX - 1]
            l2 = float('-inf') if partY == 0 else nums2[partY - 1]
            r1 = float('inf') if partX == n1 else nums1[partX]
            r2 = float('inf') if partY == n2 else nums2[partY]

            if l1 <= r2 and l2 <= r1:
                # We reached the correct partition, and will check if it's even or odd number
                if (n1 + n2) % 2 == 0:
                    return (max(l1, l2) + min(r1, r2)) / 2.0
                else:
                    return min(r1, r2)
            else:
                if l1 > r2:
                    high = partX - 1
                else:
                    low = partX + 1
        return 0.0
       
        