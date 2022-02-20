# sc ; O(N)
# tc : O(n)
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        res = []
        map1 = dict()
        for e in nums1:
            if e not in map1:
                map1[e] = 1
            else:
                map1[e] += 1
        intersect = []
        for ele in nums2:
            if ele in map1 and map1[ele]>0:
                intersect.append(ele)
                map1[ele] -=1
        return intersect
