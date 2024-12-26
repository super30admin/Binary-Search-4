"""
Tc: O(n+m), n = len of nums1, m= len of nums2
SP: O(n)
"""
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        h1 = defaultdict(int)
        for n in nums1:
            h1[n]+=1
        res = []
        for n in nums2:
            if n in h1 and h1[n]>0:
                res.append(n)
                h1[n]-=1
        return res


        