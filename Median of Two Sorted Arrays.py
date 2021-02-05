class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        #Approach: Merging, then taking median
        #Time Complexity: O(m + n)
        #Space Complexity: O(m + n)
        
        nums = []
        i = j = 0
        while i < len(nums1) and j < len(nums2):
            if nums1[i] < nums2[j]:
                nums.append(nums1[i])
                i += 1
            else:
                nums.append(nums2[j])
                j += 1
                
        while i < len(nums1):
            nums.append(nums1[i])
            i += 1
        while j < len(nums2):
            nums.append(nums2[j])
            j += 1
            
        n = len(nums)
        return nums[(n-1)//2] if n % 2 != 0 else (nums[(n-2)//2] + nums[(n)//2]) / 2