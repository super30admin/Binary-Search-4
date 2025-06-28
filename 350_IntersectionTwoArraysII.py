"""
TC -> O(m+n)
SC -> O(min(m,n))
"""
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        if len(nums1) > len(nums2):
            nums1, nums2 = nums2, nums1
        result = []
        counter = Counter(nums1)
        for num in nums2:
            if num in counter and counter[num] > 0:
                result.append(num)
                counter[num] -= 1
        return result