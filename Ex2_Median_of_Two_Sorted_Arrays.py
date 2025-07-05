# ----------------------------------------------------
# Intuition:
# Given two sorted arrays, we want to find the median of the merged array.
# 
# 1. Brute Force:
#    - Merge both arrays into one sorted array.
#    - Pick middle element(s) based on total length.
#    → Time: O(m + n), Space: O(m + n)
#
# 2. Optimal (Binary Search):
#    - Since the arrays are sorted, we use binary search on the smaller array to find a partition index 'i'.
#    - The partition divides nums1 into left (nums1[0:i]) and right (nums1[i:]) parts.
#    - We calculate a corresponding partition 'j' in nums2 so that
#      the total elements in the left partitions of both arrays equal those in the right partitions.
#    - We check if the maximum element on the left side (max(left1, left2)) is less than or equal to
#      the minimum element on the right side (min(right1, right2)).
#      If yes, this partition is correct for finding the median.
#    - The median is then either max(left1, left2) (for odd total length)
#      or average of max(left1, left2) and min(right1, right2) (for even total length).
#    - We binary search only on the smaller array to ensure indices 'i' and 'j' stay valid,
#      and the time complexity is O(log(min(m, n))) with constant space O(1).
# ----------------------------------------------------

from typing import List

class Solution:
    # ----------------------------------------------------
    # Optimal Approach: Binary Search on Smaller Array
    # Time: O(log(min(m, n)))
    # Space: O(1)
    # ----------------------------------------------------
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        if len(nums1) > len(nums2):
            nums1, nums2 = nums2, nums1  # Ensure nums1 is smaller

        m, n = len(nums1), len(nums2)
        total = m + n
        half = (total + 1) // 2  # Ensures correct mid split

        l, r = 0, m
        while l <= r:
            i = (l + r) // 2
            j = half - i

            left1 = nums1[i - 1] if i > 0 else float("-inf")
            right1 = nums1[i] if i < m else float("inf")
            left2 = nums2[j - 1] if j > 0 else float("-inf")
            right2 = nums2[j] if j < n else float("inf")

            if left1 <= right2 and left2 <= right1:
                if total % 2 == 0:
                    return (max(left1, left2) + min(right1, right2)) / 2
                else:
                    return max(left1, left2)
            elif left1 > right2:
                r = i - 1
            else:
                l = i + 1

        return 0.0  # fallback, should never reach

    # ----------------------------------------------------
    # Brute Force: Merge then Find Median
    # Time: O(m + n)
    # Space: O(m + n)
    # ----------------------------------------------------
    # def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
    #     merged = sorted(nums1 + nums2)
    #     total = len(merged)
    #     if total % 2 == 1:
    #         return merged[total // 2]
    #     else:
    #         return (merged[total // 2 - 1] + merged[total // 2]) / 2

# ----------------------------------------------------
# Example Usage:
# ----------------------------------------------------
if __name__ == "__main__":
    sol = Solution()
    print(sol.findMedianSortedArrays([1, 3], [2]))           # Output: 2.0
    print(sol.findMedianSortedArrays([1, 2], [3, 4]))         # Output: 2.5
    print(sol.findMedianSortedArrays([0, 0], [0, 0]))         # Output: 0.0
    print(sol.findMedianSortedArrays([], [1]))                # Output: 1.0
    print(sol.findMedianSortedArrays([2], []))                # Output: 2.0
