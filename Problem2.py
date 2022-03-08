# // Time Complexity : O(log(min(m,n))) where n and m are the length of the lists. 
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : Class Solution.

class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:

        l1 = len(nums1)
        l2 = len(nums2)
        if l1 > l2:
            return self.findMedianSortedArrays(nums2,nums1)
        left = 0
        right = l1
        while(left <= right):
            px =(left + right) // 2
            py = (l1 + l2 + 1) //2 - px
            if px == 0:
                mlx = float("-inf")
            else:
                mlx = nums1[px-1]
            if px == l1:
                mrx = float("inf")
            else:
                mrx = nums1[px]
            if py == 0:
                mly = float("-inf")
            else:
                mly = nums2[py - 1]
            if py == l2:
                mry = float("inf")
            else:
                mry = nums2[py]
            if mlx <= mry and mly <= mrx :
                if (l1 + l2) % 2 == 0:
                    return (max(mlx,mly) + min(mrx,mry)) / 2
                else:
                    return max(mlx,mly)
            elif mlx > mry:
                right = px -1
            else:
                left = px + 1
