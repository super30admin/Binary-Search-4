from collections import Counter


class Solution:
    # Time Complexity: O(m+n)
    # Space Complexity: O(m)
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        m = len(nums1)
        n = len(nums2)

        if m > n:
            return self.intersect(nums2, nums1)
        my_map = Counter(nums1)
        result = []

        for num in nums2:
            if my_map[num] > 0:
                result.append(num)
                my_map[num] -= 1

        return result
