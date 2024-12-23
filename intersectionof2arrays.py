class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        m = len(nums1)
        n = len(nums2)
        if (m > n):
            return self.intersect(nums2, nums1)
        hmap = {}
        for i in range(m):
            if nums1[i] in hmap:
                hmap[nums1[i]] += 1
            else:
                hmap[nums1[i]] = 1
        res = []
        for i in range(n):
            if nums2[i] in hmap and hmap[nums2[i]]>0:
                res.append(nums2[i])
                hmap[nums2[i]] -= 1
        return res


        