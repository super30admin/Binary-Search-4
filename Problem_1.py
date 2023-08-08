# Time Complexity: O(m + n)
# Space Complexity: O(min(m, n))
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

class Solution(object):
    def intersect(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        m, n = len(nums1), len(nums2)
        freqMap = {}
        for num in nums1:
            freqMap[num] = (freqMap.get(num, 0) + 1)
        res = []
        for num in nums2:
            if (num in freqMap) and (freqMap[num] > 0):
                res.append(num)
                freqMap[num] -= 1
        return res