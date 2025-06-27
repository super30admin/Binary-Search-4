"""
I implemented the binary search partitioning technique on the smaller array to efficiently find the correct partition between the two sorted arrays. At each step, I ensure that elements on the left partition are less than or equal to those on the right. Once the correct partition is found, the median is computed based on whether the combined length is even or odd.
Time Complexity: O(log min(m, ns))
Space Complexity: O(1)
"""
class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        if len(nums1) > len(nums2):
            nums1, nums2 = nums2, nums1
        m = len(nums1)
        n = len(nums2)
        low = 0
        high = m
        while low <= high:
            partX = low + (high - low) // 2
            partY = (m + n) // 2 - partX

            x1 = float('-inf') if partX == 0 else nums1[partX - 1]
            y1 = float('inf') if partX == m else nums1[partX]

            x2 = float('-inf') if partY == 0 else nums2[partY - 1]
            y2 = float('inf') if partY == n else nums2[partY]

            if x1 <= y2 and x2 <= y1:
                #correct partition
                if (m + n) % 2 == 0:
                    #even
                    return (max(x1, x2) + min(y1, y2)) / 2
                else:
                    #odd
                    return min(y1, y2)
            elif x1 > y2:
                high = partX - 1
            else:
                low = partX + 1