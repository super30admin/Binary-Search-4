from pip import List


class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        tab = dict()
        res = []
        for n in nums1:
            if tab.get(n) is None:
                tab[n] = 0
            tab[n]+=1  
        for x in nums2:
            if tab.get(x) is not None and tab[x]>0:
                res.append(x)
                tab[x]-=1
        return res