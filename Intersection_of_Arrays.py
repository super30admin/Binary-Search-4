# Time Complexity : O(m+n) --> m - len(bigger array), n - len(smaller array)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#
#
from collections import Counter


class Solution:
    def intersect(self, nums1: list[int], nums2: list[int]) -> list[int]:
        if len(nums1) > len(nums2):
            return self.intersect(nums2, nums1)
        dictu = Counter(nums1)
        result = []
        for i in nums2:
            if i in dictu and dictu[i] > 0:
                result.append(i)
                dictu[i] -= 1
        return result


print(Solution().intersect([1, 2, 2, 1], [2, 2]))


# follow-up
# if arrays are sorted

# binary-search
# TC: O(n*log(m)); SC: O(1)
# class Solution:
#     def findpivot(self, nums2, start, end, target):
#         while start <= end:
#             mid = start + (end-start)//2
#             if nums2[mid] == target and (mid == start or nums2[mid-1] != nums2[mid]):
#                 return 1, mid
#             elif nums2[mid] >= target:
#                 end = mid - 1
#             else:
#                 start = mid + 1
#         return -1
#
#     def intersect(self, nums1: list[int], nums2: list[int]) -> list[int]:
#         if len(nums1) > len(nums2):
#             return self.intersect(nums2, nums1)
#         result = []
#         nums1.sort()
#         nums2.sort()
#         ptr1 = 0
#         ptr2 = len(nums2) - 1
#         for i in nums1:
#             check = self.findpivot(nums2, ptr1, ptr2, i)
#             if check != -1:
#                 result.append(i)
#                 ptr1 = check[1] + 1
#         return result
#
#
# print(Solution().intersect([1, 2, 2, 1], [2, 2]))


# two-pointers.
# TC: O(m+n); SC: O(1)
# class Solution:
#     def intersect(self, nums1: list[int], nums2: list[int]) -> list[int]:
#         if len(nums1) > len(nums2):
#             return self.intersect(nums2, nums1)
#         result = []
#         nums1.sort()
#         nums2.sort()
#         ptr1, ptr2 = 0, 0
#         while ptr1 < len(nums1) and ptr2 < len(nums2):
#             if nums1[ptr1] == nums2[ptr2]:
#                 result.append(nums1[ptr1])
#                 ptr1 += 1
#                 ptr2 += 1
#             elif nums1[ptr1] < nums2[ptr2]:
#                 ptr1 += 1
#             else:
#                 ptr2 += 1
#         return result
#
#
# print(Solution().intersect([1, 2, 2, 1], [2, 2]))
