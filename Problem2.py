#time complexity O(log(min(m,n)))
#space complexity O1


class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        n = len(nums1)
        m = len(nums2)

        if n > m:
            return self.helper(nums2, nums1)
        else:
            return self.helper(nums1, nums2)
    
    def helper(self, nums1, nums2):
        n = len(nums1)
        m = len(nums2)
        low = 0
        high = n
        leftItemsCount = (n+m)//2
        if (n+m)%2 !=0:
            leftItemsCount+=1
            
        
        while True:
            nums1i = low + (high - low) // 2  
            nums2i = leftItemsCount - nums1i  

            nums1left = float('-inf')
            
            if nums1i > 0:
                nums1left = nums1[nums1i-1] 
            
            nums1right = float('inf')

            if nums1i < n:
                nums1right = nums1[nums1i] 

            nums2left = float('-inf')
            
            if nums2i > 0:
                nums2left = nums2[nums2i-1] 

            nums2right = float('inf')
            if nums2i < m:
                nums2right = nums2[nums2i] 
            
            if nums1left<=nums2right and nums2left <= nums1right:
                break
            if nums1left > nums2right: 
                high = nums1i-1
            elif nums1right < nums2left:
               low = nums1i + 1
        
        if (n+m)%2 !=0:
            return max(nums1left, nums2left)
        else:
            return (max(nums1left,nums2left)+min(nums2right,nums1right))/2