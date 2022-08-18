"""
Runtime Complexity:
O(m log m) - since we perform binary search on 'm' elements
Space Complexity:
O(1) - since we did not use any extra space to compute the solution.
Yes, the code worked on leetcode.
Issues while coding- No
"""

class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        if (not nums1 and not nums2) or (len(nums1) == 0 and len(nums2)==0):
            return float(0)
        m = len(nums1)
        n = len(nums2)
        if n<m:
            return self.findMedianSortedArrays(nums2,nums1)
        
        low = 0
        high = m
        
        while(low<=high):
            partX = low+(high-low)//2
            partY = (m+n)//2 - partX
            
            l1 = -math.inf if partX == 0 else nums1[partX - 1]         
            l2 = -math.inf if partY == 0 else nums2[partY - 1]
            r1 = math.inf if partX == m else nums1[partX]
            r2 = math.inf if partY == n else nums2[partY]


            if l1 <= r2 and l2 <= r1:       
                if (m + n) % 2 == 0:
                    return (max(l1, l2) + min(r1, r2)) / 2
                return min(r1, r2)

            elif l1 > r2:           
                high = partX - 1

            else:                   
                low = partX + 1


        return 0.0
