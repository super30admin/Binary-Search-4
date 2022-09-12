class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        result = []

        if nums1 is None or len(nums1) == 0 or nums2 is None or len(nums2) == 0:
            return result

        if len(nums2) > len(nums1):
            return self.intersect(nums2, nums1)

        m = {}

        for i in nums1:
            m[i] = m.get(i, 0) + 1

        for i in nums2:
            if i in m:
                result.append(i)
                m[i] = m.get(i) - 1
                if m[i] == 0:
                    m.pop(i)
        arr = []
        for i in result:
            arr.insert(i, i)

        return arr

# Hashmap Solution
# TC =O(m+n).
# Space complexity : O(n). size of the hashmap
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No
