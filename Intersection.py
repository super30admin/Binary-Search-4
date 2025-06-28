# Time Complexity: O(mlogm + nlogn)
# Spcae Complexity: O(1)
# Two Pointers Approach
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        if not nums1 and not nums2:
            return []
        result = []
        nums1.sort()
        nums2.sort()
        top = 0
        bottom = 0
        while top < len(nums1) and bottom < len(nums2):
            if nums1[top] == nums2[bottom]:
                result.append(nums1[top])
                top += 1
                bottom += 1
            elif nums1[top] < nums2[bottom]:
                top = top + 1
            else:
                bottom = bottom + 1
        return result
    
# Time Complexity: O(mlogn)
# Spcae Complexity: O(1)
# Binary Search Approach
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        if not nums1 or not nums2:
            return []

        nums1.sort()
        nums2.sort()
        result = []
        index = 0

        for num in nums1:
            loc = self.binarySearch(nums2, index, num)
            if loc < len(nums2) and nums2[loc] == num:
                result.append(num)
                index = loc + 1  # move index forward to avoid duplicates

        return result

    def binarySearch(self, nums: List[int], start: int, target: int) -> int:
        left = start
        right = len(nums) - 1
        while left <= right:
            mid = left + (right - left) // 2
            if nums[mid] < target:
                left = mid + 1
            else:
                right = mid - 1
        return left