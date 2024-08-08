#// Time Complexity : O(log(min(m,n))) 
# // Space Complexity : O(1) 
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : no because i saw the class video and then did the problem.
class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        if len(nums1) > len(nums2):
            return self.findMedianSortedArrays(nums2,nums1)
        low = 0
        high = len(nums1)

        while low <= high:
            xpart = low + (high-low) // 2
            ypart = int((len(nums1) + len(nums2))/2) - xpart

            l1 = float('-inf') if xpart == 0 else nums1[xpart - 1]
            l2 = float('-inf') if ypart == 0 else nums2[ypart - 1]
            r1 = float('inf') if xpart == len(nums1) else nums1[xpart]
            r2 = float('inf') if ypart == len(nums2) else nums2[ypart]

            if l1 <= r2 and l2 <= r1 :
                if (len(nums1) + len(nums2)) %2 == 0:
                    return (max(l1,l2) + min(r1,r2)) / 2
                else:
                    return min(r1,r2)
            elif l1 > r2:
                high = xpart - 1
            else:
                low = xpart + 1 

# Approach:
# The problem can be solved by using a modified binary search algorithm. The idea is to find the partition
# point for both arrays such that the elements on the left side of the partition point are less than or
#     equal to the elements on the right side. The partition point for the first array is denoted by
#     xpart and the partition point for the second array is denoted by ypart.