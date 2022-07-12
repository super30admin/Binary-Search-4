'''
Time Complexity: O(log(min(m,n)))
Space Complexity: O(1)
Run on Leetcode: YES
'''
from sys import maxsize


class Solution:
    def findMedianSortedArrays(self, nums1: list[int], nums2: list[int]) -> float:
        m = len(nums1)
        n = len(nums2)
        if m == 0 and n == 0:
            return 0.00
        if m > n:
            return self.findMedianSortedArrays(nums2, nums1)
        low = 0
        high = m
        while low <= high:
            xP = int(low + (high - low)/2)
            yP = int((m + n)/2) - xP
            if xP == 0:
                l1 = -maxsize - 1
            else:
                l1 = nums1[xP-1]
            if xP == m:
                r1 = maxsize
            else:
                r1 = nums1[xP]
            if yP == 0:
                l2 = -maxsize - 1
            else:
                l2 = nums2[yP-1]
            if yP == n:
                r2 = maxsize
            else:
                r2 = nums2[yP]
            if l1 <= r2 and l2 <= r1:
                if (m + n) % 2 != 0:
                    return min(r1,r2)
                return (min(r1,r2) + max(l1,l2))/2
            if l2 > r1:
                low = xP + 1
            else:
                high = xP - 1