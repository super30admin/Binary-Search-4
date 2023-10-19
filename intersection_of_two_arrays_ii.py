# Time Complexity: 
#  Space Complexity: 
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : No


class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        # nums1.sort()
        # nums2.sort()
        # result = []
        # p1 = 0
        # p2 = 0
        # m = len(nums1)
        # n = len(nums2)
        # while(p1 < m and p2 < n):
        #     if nums1[p1] == nums2[p2]:
        #         result.append(nums1[p1])
        #         p1 += 1
        #         p2 += 1
        #     elif nums1[p1] > nums2[p2]:
        #         p2 += 1
        #     else:
        #         p1 += 1
        # return result

        # d = dict()
        # for i in nums1:
        #     if i not in d:
        #         d[i] = 0
        #     d[i] += 1
        
        # res = []
        # for i in nums2:
        #     if i in d and d[i] > 0:
        #         d[i] -= 1
        #         res.append(i)
        # return res

        m = len(nums1)
        n = len(nums2)
        if m > n:
            return self.intersect(nums2, nums1)
        
        nums1.sort()
        nums2.sort()
        result = []
        low = 0
        for i in nums1:
            existsIndex = self.binarySearch(low, n-1, i, nums2)
            if existsIndex != -1:
                result.append(i)
                low = existsIndex + 1
        
        return result
    
    def binarySearch(self, low, high, target, nums):
        while(low <= high):
            mid = (low + high) // 2
            if nums[mid] == target:
                if mid == low or nums[mid-1] < nums[mid]:
                    return mid
                else:
                    high = mid -1
            if nums[mid] < target:
                low = mid + 1
            else:
                high = mid - 1
        return -1