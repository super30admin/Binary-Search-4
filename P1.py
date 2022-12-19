# TC : O(n log n)
# SC : O(1)
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        nums1.sort()
        nums2.sort()
        if len(nums1) > len(nums2):
            return self.intersect(nums2, nums1)
        l = 0
        h = len(nums2) - 1
        res = []
        left_ind = 0
        for i in nums1:
            ind = self.binary_search(i, h, left_ind, nums2)
            if ind!=-1:
                h -= 1
                nums2.remove(i)
                res.append(i)
        return res
    def binary_search(self, i, h, left_ind, nums1):
        index = -1
        while left_ind <= h:
            mid = left_ind + (h - left_ind)//2
            if nums1[mid] == i:
                index = mid
                h = mid - 1
            elif nums1[mid] > i:
                h = mid - 1
            else:
                left_ind = mid + 1
        return index
        
        
        