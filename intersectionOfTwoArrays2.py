"""
problem: Intersection of Two Arrays II
Approach: binary search in nums2 for each element in nums1 and find the leftmost element. And reduce the search
space to mid + 1 so that duplicates don't find the same number again.
t.c. = nlogm
s.c. = O(n) for sorting
"""
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        
        m, n = len(nums1), len(nums2)
        if n < m:
            return self.intersect(nums2, nums1)

        nums1.sort()
        nums2.sort()
        res = []

        l, r = 0, n - 1
        for i in range(m):
            idx = self.getLeftMostElement(l, r, nums2, nums1[i])
            if idx > -1:
                l = idx + 1
                res.append(nums1[i])
        return res
        

        
    def getLeftMostElement(self, l, r, nums, num):
        
        while l <= r:
            mid = l + (r - l)//2
            if nums[mid] == num:
                #doing mid > l since we don't want to go past l
                if mid > l and nums[mid] == nums[mid - 1]:
                    r = mid - 1
                else:
                    return mid
            elif nums[mid] > num:
                r = mid - 1
            else:
                l = mid + 1
        return -1