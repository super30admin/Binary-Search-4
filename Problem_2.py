"""
Problem2
Median of Two Sorted Arrays (https://leetcode.com/problems/median-of-two-sorted-arrays)

"""

# Approach - 1

class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        """
        Using partition and binary search
        Time Complexity : O(logn) n is the smaller number of list
        Space Complexity : O(1)
        """
        m = len(nums1)
        n = len(nums2)
        if m == 0 and n == 0 : return 0.0
        if n < m: return self.findMedianSortedArrays(nums2, nums1)
            
        l, h = 0, m
        
        while l <= h:
            
            part_x = (l + h)//2
            part_y = ((n + m )//2 - part_x)
            L1 = float("-inf") if part_x == 0 else nums1[part_x - 1]
            R1 = float("inf") if part_x == m else nums1[part_x]
            L2 = float("-inf") if part_y == 0 else nums2[part_y - 1]
            R2 = float("inf") if part_y == n else nums2[part_y]
            
            if L1 <= R2 and L2 <=  R1:
                # Correct partition
                if (n + m )%2 == 0 :
                    return (max(L1,L2) + min(R1, R2))/2
                else:
                    return min(R1,R2)
                     
            elif L2 > R1:
                l = part_x + 1
            else:
                h = part_x - 1
                
                
        return 0.0
            
                

                
            
            
            
        