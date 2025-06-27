"""
I used a hash map to store the frequency of elements from the smaller array. Then, I iterated over the second array and added elements to the result only if they appear in the hash map with a positive count, reducing the count after each match. This ensures each common element appears as many times as it exists in both arrays.
Time Complexity: O(n + m)
Space Complexity: O(min(m,n))
"""
from collections import Counter
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        if len(nums1) > len(nums2):
            nums1, nums2 = nums2, nums1
        hashMap = Counter(nums1)
        result = []
        for num in nums2:
            if hashMap[num] > 0:
                result.append(num)
                hashMap[num] -= 1
        return result  