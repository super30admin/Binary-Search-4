# Binary Search
""""// Time Complexity : O(log(n)) i.e n<m, n=len(arr1) and m=len(arr2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
"""
class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        if len(nums1) > len(nums2):
            return self.findMedianSortedArrays(nums2, nums1)
        n1 = len(nums1)
        n2 = len(nums2)
        if n1 == 0 and n2 == 0:
            return 0.0

        low = 0
        high = n1

        while low <= high:
            px = low + (high - low) // 2
            py = (n1 + n2) // 2 - px

            # l1=None
            if px == 0:
                l1 = float('-inf')
            else:
                l1 = nums1[px - 1]

            # r1=None
            if px == n1:
                r1 = float('inf')
            else:
                r1 = nums1[px]

            # l2=None
            if py == 0:
                l2 = float('-inf')
            else:
                l2 = nums2[py - 1]

            # r2=None
            if py == n2:
                r2 = float('inf')
            else:
                r2 = nums2[py]

            if l1 <= r2 and l2 <= r1:
                if (n1 + n2) % 2 == 0:
                    return (max(l1, l2) / 2 + min(r1, r2) / 2)
                else:
                    return min(r1, r2)

            elif l2 > r1:
                low = px + 1
            else:
                high = px - 1
        return 9


# 2-Pointers
""""// Time Complexity : O(m+n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
"""
# class Solution:
#     def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
#         p1 = 0
#         p2 = 0
#         result = []
#         while p1 < len(nums1) and p2 < len(nums2):
#             if nums1[p1] <= nums2[p2]:
#                 result.append(nums1[p1])
#                 p1 += 1
#             else:
#                 result.append(nums2[p2])
#                 p2 += 1
#
#         while p1 < len(nums1):
#             result.append(nums1[p1])
#             p1 += 1
#
#         while p2 < len(nums2):
#             result.append(nums2[p2])
#             p2 += 1
#
#         if len(result) % 2 == 0:
#             n = len(result) // 2
#             return (result[n] + result[n - 1]) / 2
#         else:
#             return result[len(result) // 2]

# Brute Force
""""// Time Complexity : O(mlog(n)) i.e m<n
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
"""
# class Solution:
#     def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
#         nums = []
#         nums.extend(nums1)
#         nums.extend(nums2)
#         nums.sort()
#         length = len(nums)
#         if (length % 2) == 0:
#             median = (nums[int((length / 2) - 1)] + nums[int((length / 2))]) / 2
#             return median
#         elif (length % 2) == 1:
#             median = nums[int((length // 2))]
#             return median
