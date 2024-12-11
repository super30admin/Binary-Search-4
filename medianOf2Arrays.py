# Time:O(log min(n1,n2))
# Space:O(1) constant
# Leetcode: Yes
# Issues:None

class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        # we want num1 to be smaller of the 2 so we swap 
        if len(nums1) > len(nums2):
            return self.findMedianSortedArrays(nums2,nums1)

        n1 = len(nums1)         # always smaller of the 2(or equal)            
        n2 = len(nums2)             
        
        low = 0
        high = n1
         
        while low <= high:                      # we binary search nums1 until we find the correct partitions
            partX = low + (high-low)//2         # partition 1 : Binary Search [L1|R1]
            partY = ((n1+n2)//2) - partX        # partition 2 : Median - partition 1 [L2|R2]
            # boundary condition
            L1 = float("-inf") if partX == 0 else nums1[partX-1]
            R1 = float("inf") if partX == n1 else nums1[partX]
            L2 = float("-inf") if partY == 0 else nums2[partY-1]
            R2 = float("inf") if partY == n2 else nums2[partY]

            # partition check
            if L1 <= R2 and L2 <= R1:       # correct parts
                if (n1+n2)%2 ==0:           # even
                    return (max(L1,L2)+min(R1,R2))/2.0
                else:                       # odd
                    return min(R1,R2)
            elif L2 > R1:                   # incorrect parts + L2 > R1
                low = partX +1
            else:                           # incorrect parts + L1 > R2
                high  = partX -1
        