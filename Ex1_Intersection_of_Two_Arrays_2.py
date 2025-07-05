# ----------------------------------------------------
# Intuition:
#
# 1. Optimal Approach (HashMap):
#    - The idea is to minimize extra work and space.
#    - First, we build a frequency map (hashmap/dictionary) of the smaller array.
#      This map records how many times each element appears.
#    - Then, we iterate over the other array and check if the current element
#      is present in the frequency map with a positive count.
#      If yes, it means it appears in both arrays, so we add it to the result and
#      decrease the count in the map.
#    - This way, each element is processed once or twice, so the time complexity is linear,
#      O(n + m), where n and m are the lengths of the two arrays.
#    - Space complexity depends on the size of the smaller array since we build the frequency map only for it,
#      O(min(n, m)).
#
# 2. Sorting + Two Pointers:
#    - When arrays are not sorted, sorting them first helps in efficiently finding intersections.
#    - Sort both arrays (O(n log n + m log m) time).
#    - Use two pointers, one for each array, and compare their elements:
#      - If elements match, add to result and move both pointers forward.
#      - If one element is smaller, move that pointer forward to catch up.
#    - This avoids nested loops and reduces complexity compared to naive.
#    - Space complexity is O(1) if sorting in-place.
#
# 3. Naive (Brute Force):
#    - For each element in the first array, search through the second array
#      for a matching element.
#    - Once found, add it to the result and remove that element from the second array
#      to avoid counting duplicates multiple times.
#    - This approach is simple but inefficient since each search takes O(m) time,
#      leading to overall O(n * m) time complexity.
#    - Space complexity is O(1) if done in-place, or O(m) if a copy of the second array is used.
# ----------------------------------------------------

from typing import List

class Solution:
    # ----------------------------------------------------
    # Optimal: HashMap frequency count on smaller array
    # Time: O(n + m), Space: O(min(n, m))
    # ----------------------------------------------------
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        if len(nums1) > len(nums2):
            nums1, nums2 = nums2, nums1  # build freq map on smaller array
        
        freq_map = {}
        for num in nums1:
            freq_map[num] = freq_map.get(num, 0) + 1
        
        res = []
        for num in nums2:
            if freq_map.get(num, 0) > 0:
                res.append(num)
                freq_map[num] -= 1
        return res

    # ----------------------------------------------------
    # Sorting + Two Pointers Approach
    # Time: O(n log n + m log m), Space: O(1)
    # ----------------------------------------------------
    # def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
    #     nums1.sort()
    #     nums2.sort()
    #     i, j = 0, 0
    #     res = []
    #     while i < len(nums1) and j < len(nums2):
    #         if nums1[i] == nums2[j]:
    #             res.append(nums1[i])
    #             i += 1
    #             j += 1
    #         elif nums1[i] < nums2[j]:
    #             i += 1
    #         else:
    #             j += 1
    #     return res

    # ----------------------------------------------------
    # Naive Brute Force Approach
    # Time: O(n * m), Space: O(1)
    # ----------------------------------------------------
    # def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
    #     res = []
    #     nums2_copy = nums2[:]  # avoid modifying input directly
    #     for num in nums1:
    #         if num in nums2_copy:
    #             res.append(num)
    #             nums2_copy.remove(num)
    #     return res

# ----------------------------------------------------
# Example Usage:
# ----------------------------------------------------

if __name__ == "__main__":
    sol = Solution()
    
    # Basic repeated match
    print(sol.intersect([1, 2, 2, 1], [2, 2]))  # Output: [2, 2]
    
    # Partial overlap, multiple occurrences
    print(sol.intersect([4, 9, 5], [9, 4, 9, 8, 4]))  # Output: [4, 9] or [9, 4]
    
    # No intersection
    print(sol.intersect([1, 2, 3], [4, 5, 6]))  # Output: []

    # Identical arrays
    print(sol.intersect([7, 8, 9], [7, 8, 9]))  # Output: [7, 8, 9]

    # One array is empty
    print(sol.intersect([], [1, 2, 3]))         # Output: []
    print(sol.intersect([1, 2, 3], []))         # Output: []

    # Both arrays empty
    print(sol.intersect([], []))               # Output: []

    # Different frequencies
    print(sol.intersect([1, 1, 1, 2, 2], [1, 2, 2, 2]))  # Output: [1, 2, 2]
