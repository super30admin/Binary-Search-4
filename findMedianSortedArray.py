# Time Complexity : O(logM) <- binary Search on first array
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        """
        Can put nums1 and nums2 in one list -> sort the list -> find median
        
        Use partition (binary search on the partitions)
        """
        n1 = len(nums1)
        n2 = len(nums2)
        
        if n2 < n1:
            return self.findMedianSortedArrays(nums2, nums1)

        #binary search on partitions
        left = 0 
        right = n1
        
        while left <= right:
            partX = left + (right-left)//2
            
            partY = ((n1+n2)//2) - partX
            
            if partX == 0:
                l1 = float('-inf')
            else:
                l1 = nums1[partX - 1]
                
            if partX == n1:
                r1 = float('inf')
            else:
                r1 = nums1[partX]
                
            if partY == 0:
                l2 = float('-inf')
            else:
                l2 = nums2[partY-1]
            
            if partY == n2:
                r2 = float('inf')
            else: 
                r2 = nums2[partY]
            
            if l1 <= r2 and l2 <= r1:
                #correct partition
                if (n1 + n2) % 2 == 0:
                    return (max(l1,l2) + min(r1,r2))/2
                else:
                    return min(r1,r2)
            elif l2 > r1:
                left = partX + 1
            else:
                right = partX - 1