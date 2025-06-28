# Time Complexity : O(log(min(m, n)))
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
## Three line explanation of solution in plain english:
# 1. The solution uses binary search to find the correct partition of two sorted arrays.
# 2. It calculates the maximum of the left partition and the minimum of the right partition to find the median.
# 3. The median is returned based on whether the total number of elements is odd or even.




class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        # Ensure nums1 is the smaller array
        if len(nums1) > len(nums2):
            nums1, nums2 = nums2, nums1


        m, n = len(nums1), len(nums2)


        # Binary search on the smaller array
        left, right = 0, m


        while left <= right:
            # Partition nums1 and nums2 at the current midpoint
            partition1 = (left + right) // 2
            partition2 = (m + n + 1) // 2 - partition1


            # Handle edge cases for the boundaries
            maxLeft1 = float('-inf') if partition1 == 0 else nums1[partition1 - 1]
            minRight1 = float('inf') if partition1 == m else nums1[partition1]


            maxLeft2 = float('-inf') if partition2 == 0 else nums2[partition2 - 1]
            minRight2 = float('inf') if partition2 == n else nums2[partition2]


            # Check if we have found the correct partition
            if maxLeft1 <= minRight2 and maxLeft2 <= minRight1:
                # If the total length is odd, return the max of left elements
                if (m + n) % 2 == 1:
                    return max(maxLeft1, maxLeft2)
                # If the total length is even, return the average of the max of left elements and min of right elements
                return (max(maxLeft1, maxLeft2) + min(minRight1, minRight2)) / 2
            # Adjust the partition if necessary
            elif maxLeft1 > minRight2:
                right = partition1 - 1
            else:
                left = partition1 + 1