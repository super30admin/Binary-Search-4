# To find the median of two sorted arrays in O(log(min(m, n))) time, we use a binary search approach.
# We will partition the arrays such that the left half contains half of the elements and the right half contains the other half.
# The key is to ensure that the elements on the left are smaller than those on the right, while maintaining equal or nearly equal partition sizes.
# By adjusting the partition using binary search, we can find the median without fully merging the arrays.

# Time Complexity: O(log(min(m, n))), where m and n are the lengths of nums1 and nums2.
# Space Complexity: O(1), as we are only using a constant amount of extra space.
# Did this code successfully run on Leetcode: Yes, the code runs successfully and passes all test cases.
# Any problem you faced while coding this: No significant issues, but understanding and implementing the binary search partition technique was key.

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
