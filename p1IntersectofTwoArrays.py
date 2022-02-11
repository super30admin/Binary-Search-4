#time: O(N+M)
#space: O(N+M)

class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        res = []
        dic = {}
        for i in nums1:
            if i in dic:
                dic[i] += 1
            else:
                dic[i] = 1
        for j in nums2:
            if j in dic and dic[j] != 0:
                res.append(j)
                dic[j] -= 1
        return res