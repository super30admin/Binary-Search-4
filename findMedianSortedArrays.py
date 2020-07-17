#4. Median of Two Sorted Arrays
# Time Complexity : O(log(m+n)) 
# Space Complexity : O(1)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this : No
class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        if len(nums1)>len(nums2):
            nums1, nums2 = nums2, nums1

        n1 = len(nums1)
        n2 = len(nums2)
        low = 0
        high = n1
        #import sys
        maxval = float('inf')
        minval = float('-inf')
        while low <=high:
            partX = low + (high - low) // 2
            partY = ((n1 + n2 + 1) //  2) - partX
            l1 = nums1[partX -1]  if partX != 0 else minval
            R1 = nums1[partX] if partX != n1 else maxval
            l2 = nums2[partY -1]  if partY != 0 else minval
            R2 = nums2[partY] if partY != n2 else maxval
            if l1 <= R2 and l2 <=R1:
                if (n1 + n2) % 2 == 0:
                    return (max(l1,l2) + min(R1,R2)) /2
                else:
                    return max(l1,l2)
            elif l2 > R1:
                low = partX+1
            else:
                high = partX-1  
        return -1
        
