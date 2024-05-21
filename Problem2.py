## Problem2
# Median of Two Sorted Arrays (https://leetcode.com/problems/median-of-two-sorted-arrays)

# Approach
# Using Binary Search, find the mid (PartX) of smaller list. To get equal number of elements on both sides of the partition, find the mid in larger list(PartY) using formula: (n1+n2)//2 - partX
# Set L1, L2, R1, R2. If L1 <= R2 and L2 <= R1, check if the total length is even or odd. If even, return (max(L1,L2) + min(R1,R2))/2. If odd, return return min(R1,R2)
# if the base condition is not satified and (L2 > R1), set low = partX+1 else high = partX-1. return any number, the function will never reach this return statement

# Time Complexity: O(log(min(m,n)))
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        n1 = len(nums1)
        n2 = len(nums2)
        if n1 == 0 and n2 == 0:
            return 0.0
        
        if n1>n2:
            return self.findMedianSortedArrays(nums2,nums1)
        
        low = 0
        high = n1

        while(low<=high):
            partX = low + (high-low)//2
            partY = (n1+n2)//2 - partX
            print(partY)

            if partX == 0:
                L1 = float(-inf)
            else:
                L1 = nums1[partX-1]
            
            if partX == n1:
                R1 = float(inf)
            else:
                R1 = nums1[partX]
            
            if partY == 0:
                L2 = float(-inf)
            else:
                L2 = nums2[partY-1]
            
            if partY == n2:
                R2 = float(inf)
            else:
                R2 = nums2[partY]
            
            if (L1 <= R2 and L2 <= R1 ):
                # even or odd
                if (n1+n2)%2 == 0:
                    return (max(L1,L2) + min(R1,R2))/2
                else:
                    return min(R1,R2)
            elif (L2 > R1):
                low = partX+1
            else:
                high = partX-1
    
        return -1