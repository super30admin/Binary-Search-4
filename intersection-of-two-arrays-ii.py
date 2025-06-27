# Time Complexity : O(m+n)
# Space Complexity : O(m+n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        counts1 = Counter(nums1)
        counts2 = Counter(nums2)
        result = []
        for num in counts1:
            if num in counts2:
                result.extend([num] * min(counts1[num], counts2[num]))
        return result
        