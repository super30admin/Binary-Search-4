# Binary Search
""""// Time Complexity : O(mlog(n)) i.e m<n
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
"""
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        if len(nums1) > len(nums2):
            return self.intersect(nums2, nums1)
        nums1.sort()
        nums2.sort()
        result = []
        low = 0
        high = len(nums2) - 1
        for num in nums1:
            binaryIdx = self.binarySearch(nums2, num, low, high)
            if binaryIdx != -1:
                result.append(num)
                low = binaryIdx + 1
        return result

    def binarySearch(self, arr, target, low, high):
        while low <= high:
            mid = low + (high - low) // 2

            if arr[mid] == target:
                if mid == low or arr[mid] != arr[mid - 1]:
                    return mid
                high = mid - 1
            elif arr[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        return -1

# Sorting and 2-pointers-followup
""""// Time Complexity : O(m+n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
"""
# class Solution:
#     def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
#         if len(nums1) > len(nums2):
#             return self.intersect(nums2, nums1)
#         nums1.sort()
#         nums2.sort()
#         result=[]
#         p1=0
#         p2=0
#         while p1<len(nums1) and p2<len(nums2):
#             if nums1[p1]==nums2[p2]:
#                 result.append(nums1[p1])
#                 p1+=1
#                 p2+=1
#             elif nums1[p1]<nums2[p2]:
#                 p1+=1
#             else:
#                 p2+=1
#         return result


# Brute force
""""// Time Complexity : O(m+n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
"""
# class Solution:
#     def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
#         if len(nums1) > len(nums2):
#             return self.intersect(nums2, nums1)
#         d={}
#         for num in nums1:
#             if not num in d:
#                 d[num]=0
#             d[num]+=1
#         result=[]
#         for x in nums2:
#             if x in d:
#                 result.append(x)
#                 d[x]-=1
#                 if d[x]==0:
#                     del d[x]
#         return result