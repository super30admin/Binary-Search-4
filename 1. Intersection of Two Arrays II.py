from collections import defaultdict
class Solution:
    # Time Complexity - O(n+m)
    # Space Complexity - O(min(n, m))
    def intersect(self, nums1, nums2):
        d = defaultdict(int)
        result = []
        for i in range(len(nums1)):
            d[nums1[i]] += 1
        for i in range(len(nums2)):
            if nums2[i] in d and d[nums2[i]] > 0:
                result.append(nums2[i])
                d[nums2[i]]-=1
        return result