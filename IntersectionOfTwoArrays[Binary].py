"""
Time Complexity : O(nlogm) where n is the length of smaller array and m is length of larger array
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        if len(nums1) == 0 or len(nums2) == 0:
            return []
        n1 = len(nums1)
        n2 = len(nums2)
        result = []
        mapD = {}
        # If nums2 if bigger we simple call the intersect function again and 
        # pass the arrays interchanged
        if n1 > n2:
            return self.intersect(nums2, nums1)
        # Binary Search
        nums1.sort()
        nums2.sort()
        low = 0
        high = n2 - 1
        for num in nums1:
            target = num
            # We do a binary search on the larger array that is nums2 with the target
            # as the elements in the smaller array i.e nums1
            bsIndex = self.binarySearch(nums2, low, high, target)
            # If we did not find the value in nums2 then the bsIndex would be -1
            # and if not then we append the target to the result.BaseException
            if bsIndex != -1:
                result.append(target)
                low = bsIndex + 1
        return result
    # Binary search helper function on nums2 array
    def binarySearch(self, nums, low, high, target):
        while low <= high:
            mid = (low + high)//2
            if nums[mid] == target:
                if mid == low or nums[mid] > nums[mid - 1]:
                    return mid
                high = mid - 1
            elif target > nums[mid]:
                low = mid + 1
            else:
                high = mid - 1
        return -1
        