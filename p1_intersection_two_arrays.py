# Binary Search Solution mlog(n)
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        nums1.sort(); nums2.sort()
        if len(nums1) < len(nums2):
            return self.binary_intersect(nums1, nums2)
        else:
            return self.binary_intersect(nums2, nums1)

    def binary_intersect(self, list1: List[int], list2: List[int]):
        low = 0
        high = len(list2) -1
        res = list()
        for i in list1:
            high = len(list2) - 1
            while low <= high:
                mid = int(low + (high - low)/2)
                if list2[mid] == i:
                    if mid == low or list2[mid] != list2[mid-1]:
                        res.append(i)
                        low = mid + 1
                        break
                    elif list2[mid] == list2[mid-1]:
                        high = mid - 1
                elif list2[mid] > i:
                    high = mid - 1
                else:
                    low = mid + 1
        return res

# #Two Pointer Solution O(M+N)
# class Solution:
#     def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
#         nums1.sort()
#         nums2.sort()
#         i = 0
#         j = 0
#         res = list()
#         while i <= len(nums1) - 1 and j <= len(nums2) - 1:
#             if nums1[i] == nums2[j]:
#                 res.append(nums1[i])
#                 i += 1; j += 1
#             elif nums1[i] < nums2[j]:
#                 i += 1
#             else:
#                 j += 1
#         return res


# # Hash Map Solution O(M+N)
# class Solution:
#     def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
#         num_map = dict()
#         for i in nums1:
#             if i in num_map:
#                 num_map[i] += 1
#             else:
#                 num_map[i] = 1
#         res = list()        
#         for i in nums2:
#             if i in num_map:
#                 num_map[i] -= 1
#                 res.append(i)
#                 if num_map[i] == 0:
#                     del num_map[i]
        
#         return res