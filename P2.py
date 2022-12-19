## Problem2
# Median of Two Sorted Arrays (https://leetcode.com/problems/median-of-two-sorted-arrays)
# TC : O(log(min(len(nums1), len(nums2))))
# SC : O(1)
class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        if len(nums1) > len(nums2):
            return self.findMedianSortedArrays(nums2, nums1)
        INT_MIN, INT_MAX = -2**64, 2**64
        lo, hi = 0, len(nums1)
        left_partition_size = (len(nums1) + len(nums2) + 1) // 2
        n = len(nums1) + len(nums2)
        while lo <= hi:
            p1 = lo + (hi - lo) // 2
            p2 = left_partition_size - p1
            nums1_left = nums1[p1 - 1] if p1 > 0 else INT_MIN
            nums1_right = nums1[p1] if p1 < len(nums1) else INT_MAX 
            nums2_left = nums2[p2 - 1] if p2 > 0 else INT_MIN
            nums2_right = nums2[p2] if p2 < len(nums2) else INT_MAX
            
            if nums1_left > nums2_right:
                hi = p1 - 1
            
            elif nums2_left > nums1_right:
                lo = p1 + 1
            else:
                if n & 1:
                    return max(nums1_left, nums2_left)                
                return (max(nums1_left, nums2_left) + min(nums1_right, nums2_right)) / 2
        # m = len(nums1)
        # n = len(nums2)
        # if n < m:
        #     findMedianSortedArrays(nums2, nums1)
        # l = 0 #nums1[0]
        # h = m - 1
        # while l <= h:
        #     pX = l + (h - l)//2
        #     pY = (m + n + 1)//2 - pX 
        #     if not pX:
        #         l1 = float('inf')
        #     else:
        #         l1 = nums1[pX - 1]
        #     if pY==
        #     print(l1, r1, l2, r2)
        #     if nums1[l1] > nums2[r2]:
                
                
        