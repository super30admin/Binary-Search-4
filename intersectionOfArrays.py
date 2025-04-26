from typing import List
from collections import Counter
from bisect import bisect_left


class Solution:
    # HashMap (Optimal when unsorted)
    # Time: O(n + m) | Space: O(min(n, m))
    def intersect_hashmap(self, nums1: List[int], nums2: List[int]) -> List[int]:
        if len(nums1) > len(nums2):
            nums1, nums2 = nums2, nums1  # optimize space

        count = Counter(nums1)
        result = []

        for num in nums2:
            if count[num] > 0:
                result.append(num)
                count[num] -= 1

        return result

    # Two Pointers (Sort + Merge)
    # Time: O(n log n + m log m) | Space: O(1)
    def intersect_two_pointers(self, nums1: List[int], nums2: List[int]) -> List[int]:
        nums1.sort()
        nums2.sort()
        i = j = 0
        result = []

        while i < len(nums1) and j < len(nums2):
            if nums1[i] == nums2[j]:
                result.append(nums1[i])
                i += 1
                j += 1
            elif nums1[i] < nums2[j]:
                i += 1
            else:
                j += 1

        return result

    # Binary Search (Optimized for sorted arrays)
    # Time: O(n log m) | Space: O(1)
    def intersect_binary_search(self, nums1: List[int], nums2: List[int]) -> List[int]:
        if len(nums1) > len(nums2):
            nums1, nums2 = nums2, nums1  # binary search on larger array

        nums1.sort()
        nums2.sort()
        result = []
        low = 0  # track start point in nums2

        for num in nums1:
            idx = bisect_left(nums2, num, lo=low)
            if idx < len(nums2) and nums2[idx] == num:
                result.append(num)
                low = idx + 1  # move index forward to avoid duplicates

        return result


sol = Solution()

nums1 = [1, 2, 2, 1]
nums2 = [2, 2]

print("HashMap: ", sol.intersect_hashmap(nums1, nums2))
print("Two Pointers: ", sol.intersect_two_pointers(nums1, nums2))
print("Binary Search: ", sol.intersect_binary_search(nums1, nums2))
