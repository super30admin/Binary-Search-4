# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : YES

# Any problem you faced while coding this : NO

class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        if len(nums1) == 0 and len(nums2) == 0:
            return 0
        
        n1 = len(nums1)
        n2 = len(nums2)

        if n2 < n1:
            return self.findMedianSortedArrays(nums2, nums1)
        
        low,high = 0,len(nums1)

        while True:
            partX = low + (high - low)//2
            partY = (n1 + n2)//2 - partX

            l1 = nums1[partX - 1] if partX != 0 else float('-inf')
            r1 = nums1[partX] if partX != n1 else float('inf')
            l2 = nums2[partY - 1] if partY != 0 else float('-inf')
            r2 = nums2[partY] if partY != n2 else float('inf')

            if l1 <= r2 and l2 <= r1:
                break
            
            elif l1 > r2:
                high = partX - 1
            
            else:
                low = partX + 1
        
        if (n1 + n2) % 2 == 0:
            return (max(l1,l2) + min(r1,r2)) / 2
        
        return min(r1,r2)