# Time Complexity : O(m+n) --> m - len(bigger array), n - len(smaller array)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#
#

# TC: O(log(n)), n --> length of smaller array; SC - O(1)
class Solution:
    def findMedianSortedArrays(self, nums1: list[int], nums2: list[int]) -> float:
        n1 = len(nums1)
        n2 = len(nums2)
        if n1 > n2:
            return self.findMedianSortedArrays(nums2, nums1)
        start = 0
        end = n1
        while start <= end:
            midx = start + (end-start)//2
            midy = (n1+n2)//2 - midx
            l1 = float('-inf') if midx == 0 else nums1[midx-1]
            l2 = float('-inf') if midy == 0 else nums2[midy-1]
            r1 = float('inf') if midx == n1 else nums1[midx]
            r2 = float('inf') if midy == n2 else nums2[midy]
            if l1 <= r2 and l2 <= r1:
                if (n1+n2) % 2 == 0:
                    return ((max(l1, l2)) + (min(r1, r2))) / 2
                else:
                    return min(r1, r2)
            elif l2 > r1:
                start = midx + 1
            else:
                end = midx - 1


print(Solution().findMedianSortedArrays([1, 3], [2]))

# TC: O(m+n); SC: O(m+n)
# two-pointer approach.
# class Solution:
#     def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
#         ptr1 = 0
#         ptr2 = 0
#         result = []
#         while ptr1 < len(nums1) and ptr2 < len(nums2):
#             if nums1[ptr1] <= nums2[ptr2]:
#                 result.append(nums1[ptr1])
#                 ptr1 += 1
#             else:
#                 result.append(nums2[ptr2])
#                 ptr2 += 1
#         while ptr1 < len(nums1):
#             result.append(nums1[ptr1])
#             ptr1 += 1
#         while ptr2 < len(nums2):
#             result.append(nums2[ptr2])
#             ptr2 += 1
#         if len(result) % 2 == 0:
#             n = len(result)//2
#             return (result[n] + result[n-1])/2
#         else:
#             return result[len(result)//2]
#
#
# print(Solution().findMedianSortedArrays([1, 3], [2]))
