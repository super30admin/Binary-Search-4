# TC : O(NlogN) - N is the length of the longest array
# SC : O(n)
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        nums1.sort()
        nums2.sort()
        
        # Just pass nums2 in place of inplace of nums 1 and vice versa to the same function - now new len(nums1) will be less than new len(nums2)
        if len(nums1) > len(nums2) : return self.intersect(nums2,nums1)

        result = []
        low, high = 0, len(nums2) - 1 
        for n in nums1:
            found = self.binary_search(nums2, n, low, high)
            if found != -1:
                result.append(n)
                low = found + 1
        return result
    
    
    def binary_search(self, nums, target, low, high):
        while low <= high:
            mid = low + (high-low) // 2
            if nums[mid] == target: 
                if mid == low or nums[mid] != nums[mid-1]:
                    return mid
                else:
                    high = mid - 1
            elif nums[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        return -1
