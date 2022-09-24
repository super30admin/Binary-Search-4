# Time Complexity : O(n log n) + O(m log m) where n and m are legth of nums1 and nums2 array respectively
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def __init__(self):
        self.start = 0
        self.end = 0
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        if len(nums1) > len(nums2):
            return self.intersect(nums2, nums1)
        nums1 = sorted(nums1)
        nums2 = sorted(nums2)
        i, j = 0, 0
        result = []
        self.start = 0
        self.end = len(nums2) - 1
        for i in range(len(nums1)):
            if self.isFound(nums1[i], nums2):
                result.append(nums1[i])
         
        return result
    
    def isFound(self, n, nums):
        low = self.start
        high = self.end
        
        while low <= high:
            mid = low + (high - low) // 2
            if nums[mid] == n:
                while mid != 0 and nums[mid - 1] == n and mid - 1 >= low:
                    mid -= 1
                self.start = mid + 1
                return True
            elif n < nums[mid]:
                high = mid - 1
            else:
                low = mid + 1
                
        return False