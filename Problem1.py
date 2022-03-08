# // Time Complexity : O(n+m) where n and m are the length of the lists. 
# // Space Complexity : O(min(n,m)) where n and m are the length of the lists. 
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : Class Solution.

class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        n1 = len(nums1)
        n2 = len(nums2)
        if n1 > n2:
            return self.intersect(nums2,nums1)
        d = dict()
        for i in nums1:
            if i not in d:
                d[i] = 1
            else:
                d[i] += 1
        res = []
        for i in nums2:
            if i in d:
                res.append(i)
                d[i] -= 1
                if d[i] == 0:
                    d.pop(i)
        return res
