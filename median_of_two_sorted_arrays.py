# Time Complexity : O(log min(n,m)) where n and m are legth of nums1 and nums2 array respectively
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        m = len(nums1)
        n  = len(nums2)
        
        if m > n:
            return self.findMedianSortedArrays(nums2, nums1)
        
        low = 0
        high = m
        
        while low <= high:
            pivotX = low + (high - low) // 2
            pivotY = ((m+n) // 2) - pivotX
            
            left1 = float("-inf") if pivotX == 0 else nums1[pivotX - 1]
            right1 = float("inf") if pivotX == m else nums1[pivotX]
            left2 = float("-inf") if pivotY == 0 else nums2[pivotY - 1]
            right2 = float("inf") if pivotY == n else nums2[pivotY]
            
            
            if left1 <= right2 and left2 <= right1:
                if (m + n) % 2 == 0:
                    return (max(left1, left2) + min(right1, right2)) / 2
                else:
                    return min(right1, right2)
                
            elif left2 > right1:
                low = pivotX + 1
            else:
                high = pivotX - 1
        