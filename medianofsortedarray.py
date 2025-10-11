# Time Complexity : O(log(min(N1, N2))) where N1 and N2 are the lengths of the input arrays
# Space Complexity : O(1) as we are using a constant amount of space
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach:
# I am first ensuring that nums1 is the smaller array. This is to ensure that we are doing binary search on the smaller array.
# I am using binary search to find the correct partition of both arrays such that the left half of both arrays is less than or equal to the right half of both arrays.
# I am also handling the edge cases where the partition is at the start or end of the array by using -infinity and +infinity so that the comparisons can be made without going out of bounds.
# I am calculating the partition indices for both arrays and then checking if the maximum element on the left side of both partitions
# is less than or equal to the minimum element on the right side of both partitions.
# If the partitions are correct, I am calculating the median based on the total length of both arrays (even or odd).
# If the partitions are not correct, I am adjusting the binary search range accordingly.



from typing import List
class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        if len(nums1) > len(nums2):
            nums1,nums2 = nums2,nums1
        n1 = len(nums1)
        n2 = len(nums2)
        left = 0
        right = n1
        while left <= right:
            partX = left + (right - left)//2
            partY = (n1 + n2)//2 - partX
            # For the nums1 part to split into needed part
            left1 = float('-inf') if partX == 0 else nums1[partX - 1]
            right1 = float('inf') if partX == n1 else nums1[partX ]
            # For the nums2 part to split into needed part
            left2 = float('-inf') if partY == 0 else nums2[partY - 1]
            right2 = float('inf') if partY == n2 else nums2[partY]

            if left1 <= right2 and left2 <= right1:
                if (n1 + n2) % 2 != 0:
                    return min(right1,right2)
                return (max(left1,left2) + min(right1,right2))/2 
            elif left1 > right2:
                right = partX
            else:
                left = partX + 1
