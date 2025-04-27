# Approach:
# - Always binary search on the smaller array to minimize the search space.
# - Partition both arrays so that left halves and right halves can form the correct median.
# - Check partition conditions and adjust binary search accordingly.
#
# Time Complexity: O(log(min(m, n))), where m and n are the lengths of the two arrays.
# Space Complexity: O(1), no extra space used apart from a few variables.

class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        if len(nums1) > len(nums2):
            nums1, nums2 = nums2, nums1
    
        m, n = len(nums1), len(nums2)
        left, right = 0, m
    
        while left <= right:
            partition1 = left + (right - left) // 2
            partition2 = (m + n) // 2 - partition1
        
            # Calculate edge values for partitions
            maxLeft1 = float('-inf') if partition1 == 0 else nums1[partition1 - 1]
            minRight1 = float('inf') if partition1 == m else nums1[partition1]
        
            maxLeft2 = float('-inf') if partition2 == 0 else nums2[partition2 - 1]
            minRight2 = float('inf') if partition2 == n else nums2[partition2]
        
            # Check if partitions are correct
            if maxLeft1 <= minRight2 and maxLeft2 <= minRight1:
                if (m + n) % 2 == 0:
                    return (max(maxLeft1, maxLeft2) + min(minRight1, minRight2)) / 2.0
                else:
                    return min(minRight1, minRight2)
            elif maxLeft1 > minRight2:
                right = partition1 - 1
            else:
                left = partition1 + 1
