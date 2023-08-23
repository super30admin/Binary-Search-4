# Time Complexity : O(logn1)
# Space Complexity :O(1)
# Passed on Leetcode: yes

class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        if len(nums1) == 0 and len(nums2) == 0:
            return 0.0

        if len(nums1) > len(nums2):
            return self.findMedianSortedArrays(nums2, nums1)

        n1, n2 = len(nums1), len(nums2)
        low, high = 0, n1

        while low <= high:
            partX = low + (high - low) // 2
            partY = (n1 + n2) // 2 - partX

            l1 = float("-inf") if partX == 0 else nums1[partX - 1]
            r1 = float("inf") if partX == n1 else nums1[partX]
            l2 = float("-inf") if partY == 0 else nums2[partY - 1]
            r2 = float("inf") if partY == n2 else nums2[partY]

            if l1 <= r2 and l2 <= r1:
                if (n1 + n2) % 2 == 0:
                    return (max(l1, l2) + min(r1, r2)) / 2
                else:
                    return min(r1, r2)
            elif l1 > r2:
                high = partX - 1
            else:
                low = partX + 1