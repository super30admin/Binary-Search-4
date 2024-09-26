class Solution:
    
    """
    
        Name : Shahreen Shahjahan Psyche
        Time : log(M + N) [M and N are the size of the arrays]
        Space: O(1)
    
    """
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        
        if len(nums1)>len(nums2):
            return self.findMedianSortedArrays(nums2, nums1)
        
        left = 0
        right = len(nums1)
        partLeftX = 0
        partRightX = 0
        partLeftY = 0
        partRightY = 0
        
        maxLeft = float('-inf')
        maxRight = float('inf')
        
        while(left<=right):
            
            partX = left + (right - left)//2
            partY = (len(nums1) + len(nums2)+1)//2 - partX
            
            if partX == 0:
                partLeftX = maxLeft
            else:
                partLeftX = nums1[partX-1]
                
            if partX == len(nums1):
                partRightX = maxRight
            else:
                partRightX = nums1[partX]
            
            if partY == 0:
                partLeftY = maxLeft
            else:
                partLeftY = nums2[partY-1]
                
            if partY == len(nums2):
                partRightY = maxRight
            else:
                partRightY = nums2[partY]
            
            
            if partLeftX <= partRightY and partLeftY <= partRightX:
                if (len(nums1)+len(nums2))%2 == 0:
                    L = max(partLeftX, partLeftY)
                    R = min(partRightX, partRightY)
                    return (L+R)/2
                else:
                    return max(partLeftX, partLeftY)
            
            elif partLeftX > partRightY:
                right = partX - 1
            else:
                left = partX + 1
                
        return 0.0
            
            
        
