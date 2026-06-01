from typing import Counter


# class Solution:
#     def intersect(self, nums1, nums2):
#         n, m = len(nums1), len(nums2)
#         if n > m:
#             return self.intersect(nums2, nums1)
#         map = Counter(nums1)
#         result = []
#         for num in nums2:
#             if num in map:
#                 result.append(num)
#                 map[num] -= 1
#                 if map[num] == 0:
#                     map.pop(num)
#         return result
    

class Solution:
    def intersect(self, nums1, nums2):
        n, m = len(nums1), len(nums2)
        nums1.sort()
        nums2.sort()
        p1, p2 = 0, 0
        result = []
        while p1 < n and p2 < m:
            ele1 = nums1[p1]
            ele2 = nums2[p2]
            if ele1 == ele2:
                result.append(ele1)
                p1 += 1
                p2 += 1
            elif ele1 < ele2:
                p1 += 1
            else:
                p2 += 1
        return result
