# Binary-Search-4



## Problem1 
Intersection of Two Arrays II (https://leetcode.com/problems/intersection-of-two-arrays-ii/)

class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        c = collections.Counter(nums1) & collections.Counter(nums2)
        ans = []
        for k, v in c.items():
            ans.extend([k] * v)
        return ans

## Problem2
Median of Two Sorted Arrays (https://leetcode.com/problems/median-of-two-sorted-arrays)


class Solution(object):
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        nums1 += nums2
        nums1.sort()
        l = len(nums1)
        if l % 2 != 0:
            return nums1[l//2]
        return (nums1[l//2] + nums1[l//2-1]) / 2.0