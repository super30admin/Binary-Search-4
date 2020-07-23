# Time Complexity : Add - O(log(min(m,n)))
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
'''
1. USe Binary search on samller array to find a partition in X
2. Corresponding to partition in X, find partition in Y 
3. calculate L1, R1, L2, R2
4. If L1<R2 and L2<R2, then  we have found the right partition and break out
5. Now depending on whether is total input was even or odd return the median
'''

import sys
class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        
        if len(nums2) < 1 and len(nums1)<1:
            return
        
        if len(nums2) < 1:
            n1 = len(nums1)
            return nums1[n1//2] if n1%2 !=0 else (nums1[n1//2] + nums1[(n1//2)-1])/2
        
        if len(nums1) < 1:
            n2 = len(nums2)
            return nums2[n2//2] if n2%2 !=0 else (nums2[n2//2] + nums2[(n2//2)-1])/2
        
        
        n1 = len(nums1)
        n2 = len(nums2)
        
        if n1 > n2:
            return self.findMedianSortedArrays(nums2, nums1)
        
        low = 0
        high = n1
        while low <= high:
            
            partX = low + (high-low)//2
            partY = ((n1+n2+1)//2) - partX
            
            L1 = -sys.maxsize if partX == 0 else nums1[partX-1]
            R1 = sys.maxsize if partX == n1  else nums1[partX]
            L2 = -sys.maxsize if partY == 0  else nums2[partY-1]
            R2 =  sys.maxsize if partY == n2  else nums2[partY]
            
            

            if L2 >= R1:
                low = partX + 1
            
            elif L1 >= R2:
                high = partX - 1
                
            elif L1 < R2 and L2 < R1:
                break
                
        return max(L1,L2) if (n1+n2)%2 != 0 else (max(L1,L2) + min(R1,R2))/2
                
                
                
            
        