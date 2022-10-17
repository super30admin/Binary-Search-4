#Time Complexity: O(n)
#Space Complexity: O(n)
#Did it run on leetcode: yes

class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        result = []
        values = {}
        for i in nums1:
            if i in values:
                values[i] += 1
                continue
            values[i] = 1
        for i in nums2:
            if i in values and values[i]:
                result.append(i)
                values[i] -= 1
        return result