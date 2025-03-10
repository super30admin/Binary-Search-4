# Time Complexity : O(m + n) where m is the length of nums1 and n is the length of nums2
# Space Complexity : O(1)
class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        res = []
        p1 = 0
        p2 = 0
        while p1 < len(nums1) and p2 < len(nums2):
            if nums1[p1] < nums2[p2]:
                res.append(nums1[p1])
                p1 += 1
            else:
                res.append(nums2[p2])
                p2 += 1
        if p1 < len(nums1):
            res.extend(nums1[p1:])
        if p2 < len(nums2):
            res.extend(nums2[p2:])
        print(res) 
        mid = len(res) // 2
        if len(res) % 2 == 0:
            return (res[mid] + res[mid - 1]) / 2
        else:
            return res[mid]