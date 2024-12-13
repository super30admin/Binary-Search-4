# The findMedianSortedArrays method finds the median of two sorted arrays.

# Binary search on the smaller array ensures efficient partitioning.
# Use pointers 'l' and 'r' to find the correct partition indices in both arrays.
# Check if elements on the left are less than or equal to elements on the right.
# - If true, calculate the median based on the total length (odd or even).
# - If not, adjust the binary search boundaries.

# TC: O(log(min(n, m))) - Binary search on the smaller array.
# SC: O(1) - Constant space usage.


from typing import List


class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        A, B = nums1, nums2
        total = len(nums1) + len(nums2)
        half = total // 2

        if len(B) < len(A):
            A, B = B, A

        l, r = 0, len(A) - 1
        while True:
            i = (l + r) // 2
            j = half - i - 2

            Aleft = A[i] if i >= 0 else float("-infinity")
            Aright = A[i + 1] if (i + 1) < len(A) else float("infinity")
            Bleft = B[j] if j >= 0 else float("-infinity")
            Bright = B[j + 1] if (j + 1) < len(B) else float("infinity")

            if Aleft <= Bright and Bleft <= Aright:
                if total % 2:
                    return min(Aright, Bright)
                return (max(Aleft, Bleft) + min(Aright, Bright)) / 2
            elif Aleft > Bright:
                r = i - 1
            else:
                l = i + 1