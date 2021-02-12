# T = O(mlogn)
# S = O(1)

# Approach:
# Choose a number in the smaller array and do a binary search on the longer array
# every time a binary search is performed the low pointer is advanced by the previous
# found  value.

class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        result = []
        if not nums1 or not nums2:
            return result
        l1 = len(nums1)
        l2 = len(nums2)
        
        if l1 > l2:
            return self.intersect(nums2,nums1)
        nums1.sort()
        nums2.sort()
        
        low = 0
        for i in nums1:
            res = self.binarySearch(nums2, low, l2-1, i)
            if res != -1:
                low = res+1
                result.append(nums2[res])
        return(result)
    
    def binarySearch(self, nums, low, high, target):
        while low <= high:
            mid = low+(high-low)//2
            if nums[mid] == target:
                if mid == low or nums[mid] > nums[mid-1]:
                    return mid
                else:
                    high = mid-1
            elif nums[mid] < target:
                low = mid+1
            else:
                high = mid-1
        return -1