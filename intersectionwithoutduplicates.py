class Solution:
    def intersection(self, nums1: List[int], nums2: List[int]) -> List[int]:
        ###O(n+m)
        ###intersection2 using sets
        set1 = set(nums1)
        set2 = set(nums2)
        self.result = []
        if len(set1) < len(set2):
            return self.returnintersection(set1, set2)
        else:
            return self.returnintersection(set2, set1)

    def returnintersection(self, s1, s2):
        for v in s1:
            if v in s2:
                self.result.append(v)
        return self.result
