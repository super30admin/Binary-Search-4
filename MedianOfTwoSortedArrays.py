"""
Time Complexity : O(logn) where n is length of smaller array of nums1 and nums2
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""
class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        if len(nums1) == 0 and len(nums2) == 0:
            return 0.0
        n1 = len(nums1)
        n2 = len(nums2)
        # If nums1 if larger then we interchange the arrays
        if n1 > n2:
            return self.findMedianSortedArrays(nums2, nums1)
        low = 0
        high = n1
        # We do a binary search on smaller array and do 4 partitions l1, l2 for 
        # smaller array and r1, r2 for larger array. We do partions as: for l1 if 
        # the partition equals 0 we set it to -infinity else we set it to mid - 1
        # Same for r1. Now for l2 if partY equals length of larger array we set it to 
        # infinity else we set it to partY - 1 and same for r2
        while low <= high:
            partX = (low + high)//2
            partY = (n1 + n2)//2 - partX
            l1 =  float('-inf') if partX == 0 else nums1[partX - 1]
            l2 = float('inf') if partX == n1 else nums1[partX]
            r1 = float('-inf') if partY == 0 else nums2[partY - 1]
            r2 = float('inf') if partY == n2 else nums2[partY]
            # Now if among 4 partitions if 1st element is smaller than 4th and
            # 2nd element is higher than 3rd element we check if the total length is 
            # is odd or even. If even we take max of 1st and 3rd partition and min of
            # 2nd and 4th partition
            if l1 <= r2 and r1 <= l2:
                if (n1 + n2) % 2 == 0:
                    return (max(l1,r1) + min(l2, r2))/2
                else:
                    return max(r1, l2)
            # if 1st partition element is greater than 4th then we decrement high 
            # pointer else we increment low pointer
            elif l1 > r2:
                high = partX - 1
            else:
                low = partX + 1
                
                
            