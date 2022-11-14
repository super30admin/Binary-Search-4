"""
FAANMG Problem #93 {Hard}


4. Median of Two Sorted Arrays

Time complexity : O(logn) --> n = length of smaller array
Space complexity : O(1)
        
Did this code successfully run on Leetcode : Yes


 We perform binary search to find the right partition. We perfom this onmly on nums 1 and we will automatically find its corresponding parition in nums2

@name: Rahul Govindkumar_RN27JUL2022
"""


class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        
        # fetch the lengths of 2 arrays
        n1 = len(nums1)
        n2 = len(nums2)

        # make n1 as the smaller array
        if n1 > n2:
            return self.findMedianSortedArrays(nums2, nums1)

        # partitioning the array from 0 till n1, so that in every partition, we have just one element
        low = 0
        high = n1
        
        # traverse until the low <= high
        while low <= high:
            # find the partition of array using the binary search
            partX = low + (high - low) // 2
            
            # find partition of Y using the median formula such that each side has equal elements if even and left has one more than right for odd
            partY = (n1 + n2) // 2 - partX
            
            
            
            # fetch l1, l2, r1 and r2 using the partition index of X and Y
            l1 = float('-inf') if partX == 0 else nums1[partX - 1]
            r1 = float('inf') if partX == n1 else nums1[partX]
            l2 = float('-inf') if partY == 0 else nums2[partY - 1]
            r2 = float('inf') if partY == n2 else nums2[partY]
            
            # check if the after partition, we have the array sorted, if so, then return the result as avg for even numbers and middle when odd
            if l1 <= r2 and l2 <= r1:
                #Correct partition
                if (n1 + n2)%2 == 0:
                    return (max(l1,l2)+min(r1,r2)) / 2
                else:
                    return min(r1,r2)

            # if the l2 > r1, that means we need to shift the partition to the right side, else move to the left side
            elif l2 > r1:
                low = partX + 1
            else:
                high = partX - 1