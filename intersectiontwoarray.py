import collections
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:           
        c1 = collections.Counter(nums1)
        c2 = collections.Counter(nums2)
        output = []
        for key in c1.keys() & c2.keys():
            output.extend([key]*min(c1[key], c2[key]))
        
        return output