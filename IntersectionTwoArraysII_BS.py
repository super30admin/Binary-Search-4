# TC: O(M logN) where N is the size of larger array and M is the size of smaller array, since we are iterating over smaller array and performing binary search over larger array. 
# SC: O(1) since we do not use any extra space.

class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        if not nums1 or not nums2 or len(nums1) == 0 or len(nums2) == 0: 
            return
        
        self.final = []
        nums1.sort() 
        nums2.sort()
        
        def binarySearch(nums, low, high, target):
            while (low <= high): 
                mid = (low + high) // 2
                if nums[mid] == target:
                    if mid == low or nums[mid] > nums[mid - 1]: 
                        return mid
                    else:
#                     keep moving to left
                        high = mid - 1
                elif nums[mid] > target: 
                    high = mid - 1
                else: 
                    low = mid + 1
            return -1           
            
#         length of nums1 less than that of nums2
        if len(nums1) < len(nums2): 
            return self.intersect(nums2, nums1)
#         length of nums2 is less than nums1, nums1>nums2
        low = 0
        high = len(nums1) - 1
        for i in range(len(nums2)): 
            idx = binarySearch(nums1, low, high, nums2[i])
            if idx != -1: 
                self.final.append(nums2[i])
                low = idx + 1    
        
        return self.final
