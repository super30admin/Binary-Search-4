#Time And Space Compelxity O(N)

class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        res = []
        dict1 = dict()
        for e in nums1:
            if e not in dict1:
                dict1[e] = 1
            else:
                dict1[e] += 1
        intersect = []
        for ele in nums2:
            if ele in dict1 and dict1[ele]>0:
                intersect.append(ele)
                dict1[ele] -=1
        return intersect
