#-------- Solution 1: Binary search on partition--------
''' Time Complexity : O(n) 
    Space Complexity : O(1) 
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this :  No
'''

class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        m, n = len(nums1), len(nums2)
        
        if m > n:
            return self.findMedianSortedArrays(nums2,nums1)

        l ,r = 0, m
        while l <= r:
            mid = (l+r)//2
            y = (m+n) // 2 - mid
            l1 = float("-inf") if mid == 0 else nums1[mid - 1]
            r1 = float("inf") if mid == m else nums1[mid]
            l2 = float("-inf") if y == 0 else nums2[y - 1]
            r2 = float("inf") if y == n else nums2[y]

            if l1 <= r2 and l2 <= r1:
                if (m+n) % 2 == 0:
                    return (max(l1,l2) + min(r1,r2)) / 2
                else:
                    return min(r1,r2)

            elif l1 > r2:
                r = mid
            else:
                l = mid + 1
        
