# Time Complexity = O(m logm + n logn)
# Space Complexity = O(1)
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        if not nums1 and not nums2:
            return []
        res = []
        nums1.sort()
        nums2.sort()
        ptr1,ptr2 = 0,0
        while ptr1 < len(nums1) and ptr2 < len(nums2):
           if nums1[ptr1] == nums2[ptr2]:
               res.append(nums1[ptr1])
               ptr1 += 1
               ptr2 += 1
           elif nums1[ptr1] < nums2[ptr2]:
               ptr1 += 1
           else:
               ptr2 += 1
        return res