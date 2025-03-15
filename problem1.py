# Time Complexity : O(m+n)
# Space Complexity : O(min(m,n))
# Did this code successfully run on Leetcode : YES

# Any problem you faced while coding this : NO

class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        cache1 = {}
        res = []
        for num in nums1:
            cache1[num] = cache1.get(num, 0) + 1

        for num in nums2:
            if num in cache1 and cache1[num] != 0:
                res.append(num)
                cache1[num] -= 1
        
        return res