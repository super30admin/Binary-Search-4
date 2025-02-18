class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        # T: O(m + n), S: O(min(m, n))
        # counts = Counter(nums1)  # num -> count
        counts = {}  # num -> count
        for num in nums1:
            counts[num] = 1 + counts.get(num, 0)

        result = []

        for num in nums2:
            if num in counts and counts[num] > 0:  # If num exists in nums1
                result.append(num)
                counts[num] -= 1  # Reduce frequency

        return result
