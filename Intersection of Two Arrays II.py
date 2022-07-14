"""
TC:O(M+N)
"""
from collections import Counter
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        counter = Counter(nums1)
        
        result = []
        for i in nums2:
            freq = counter[i]
            if freq != None and freq > 0:
                counter[i]-=1
                result.append(i)
        
        return result
