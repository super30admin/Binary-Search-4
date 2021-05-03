# T.C --> O(M+N)
# S.C--> O(N)
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        if nums1 is None or nums2 is None:
            return []
        n1 = len(nums1)
        n2 = len(nums2)
        res = []
        if n2 < n1:
            return self.intersect(nums2, nums1)
        freq_map = {}
        for num in nums1:
            if num in freq_map:
                freq_map[num] += 1
            else:
                freq_map[num] = 1
        for num in nums2:
            if num in freq_map.keys():
                if freq_map[num] > 0:
                    res.append(num)
                    freq_map[num] -= 1
        return res
