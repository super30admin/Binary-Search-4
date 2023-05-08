# Time COmplexity : O(n + m), where n and m are the lengths of nums1 and nums2, respectively
# Space COmplexity : O(n + m)
from collections import Counter
from typing import List

class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        counter1 = Counter(nums1)
        counter2 = Counter(nums2)
        
        result = []
        for num, count in counter1.items():
            if num in counter2:
                result.extend([num] * min(count, counter2[num]))
        
        return result