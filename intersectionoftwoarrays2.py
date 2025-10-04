# Time Complexity:O(m+n)
# Space Complexity: O(m)
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        m = len(nums1)
        n = len(nums2)

        hashmap = {}
        for i in nums1:
            hashmap[i] = hashmap.get(i, 0) + 1

        result = []
        for j in nums2:
            if j in hashmap:
                result.append(j)
                hashmap[j] -= 1
                if hashmap[j] == 0:
                    del hashmap[j]
        return result
