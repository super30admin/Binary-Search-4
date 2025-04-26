from typing import List


class Solution:
    # Approach 1: Binary Search on smaller array
    # TC: O(log(min(n, m))) | SC: O(1)

    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        n1, n2 = len(nums1), len(nums2)

        # Ensure binary search is on the smaller array
        if n1 > n2:
            return self.findMedianSortedArrays(nums2, nums1)

        low, high = 0, n1

        while low <= high:
            partX = (low + high) // 2
            partY = (n1 + n2 + 1) // 2 - partX

            # Handle edge cases at partitions
            L1 = float("-inf") if partX == 0 else nums1[partX - 1]
            R1 = float("inf") if partX == n1 else nums1[partX]
            L2 = float("-inf") if partY == 0 else nums2[partY - 1]
            R2 = float("inf") if partY == n2 else nums2[partY]

            # Valid partition found
            if L1 <= R2 and L2 <= R1:
                if (n1 + n2) % 2 == 0:
                    return (max(L1, L2) + min(R1, R2)) / 2
                else:
                    return max(L1, L2)
            elif L1 > R2:
                high = partX - 1
            else:
                low = partX + 1

        # Should never reach here if inputs are valid
        raise ValueError("Input arrays are not valid")

    # Approach 2: Brute Force Merge and Find Median
    # TC: O(n + m) | SC: O(n + m)
    def findMedianSortedArraysBrute(self, nums1: List[int], nums2: List[int]) -> float:
        merged = []
        i, j = 0, 0

        # Merge the two sorted arrays
        while i < len(nums1) and j < len(nums2):
            if nums1[i] < nums2[j]:
                merged.append(nums1[i])
                i += 1
            else:
                merged.append(nums2[j])
                j += 1

        # Append remaining elements
        while i < len(nums1):
            merged.append(nums1[i])
            i += 1
        while j < len(nums2):
            merged.append(nums2[j])
            j += 1

        # Calculate the median
        mid = len(merged) // 2
        if len(merged) % 2 == 0:
            return (merged[mid - 1] + merged[mid]) / 2
        else:
            return merged[mid]


if __name__ == "__main__":
    sol = Solution()
    nums1 = [1, 3]
    nums2 = [2]

    print("Median (Optimized):", sol.findMedianSortedArrays(nums1, nums2))
    print("Median (Brute):", sol.findMedianSortedArraysBrute(nums1, nums2))
