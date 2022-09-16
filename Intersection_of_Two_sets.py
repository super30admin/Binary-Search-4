'''
Time Complexity - O(m+n)
Space Complexity - O(min(m,n))
'''


class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        n1 = len(nums1)
        n2 = len(nums2)

        if n1 > n2:
            return self.intersect(nums2, nums1)
        hmap = {}
        res = []
        for i in nums1:
            if i not in hmap:
                hmap[i] = 0
            hmap[i] += 1

        for k in nums2:
            if k in hmap.keys() and hmap[k]:
                res.append(k)
                hmap[k] -= 1
        return res
