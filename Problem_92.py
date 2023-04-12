# TC : O(max(N, M))
# SC : O(min(N, M))

class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        res = []
        map = {}

        for i in nums1:
            if i not in map:
                map[i] = 0
            map[i] = map[i] + 1
            
        for j in nums2:
            if j in map and map[j] > 0:
                res.append(j)
                map[j] -= 1

        return res