
'''
Problem: Median of Two Sorted Arrays
Time Complexity: O(log n) where n is length of smaller array
Space Complexity: O(1)
Did this code successfully run on Leetcode: Yes
Any problem you faced while coding this: No
Your code here along with comments explaining your approach:
        perform binary serach on partition
        update partitions on the basis of l1, l2, r1 and r2 values

'''

class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        n1 = len(nums1)
        n2 = len(nums2)
        if n1>n2:
            return self.findMedianSortedArrays(nums2, nums1)
        low = 0
        high = len(nums1)

        while low<=high:
            partX = low + (high-low)//2
            partY = (n1+n2)//2 - partX
            l1 = float('-inf') if partX == 0 else nums1[partX-1] 
            r1 = float('inf') if  partX == n1 else nums1[partX]
            l2 = float('-inf') if partY == 0 else nums2[partY-1] 
            r2 = float('inf') if partY == n2 else nums2[partY]

            if l1<=r2 and l2<=r1:
                if ((n1+n2)%2 == 0):
                    return (min(r1,r2) + max(l1,l2))/2
                else:
                    return min(r1,r2)
            elif l2>r1:
                low = partX+1
            else:
                high = partX-1
        
        return -1