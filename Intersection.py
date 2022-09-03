# Time complexity : O(n + m)
# Space complexity : O(min(n,m)) - to maintain set
# Leetcode : Solved and submitted
class Solution:
    def intersection(self, nums1: List[int], nums2: List[int]) -> List[int]:
        # find length of both lists
        n1 = len(nums1)
        n2 = len(nums2)
        
        # set the lower length of list to nums1 and other to nums2
        if n1 > n2:
            return self.intersection(nums2, nums1)
        
        # declare the set and resulting list
        seen = set()
        res = []
        
        # adding the numbers to the set
        for i in range(n1):
            seen.add(nums1[i])
        
        # traversing the numbers from nums2
        for num in nums2:
            # if num is present in set, then append it to result and remove it from set
            # so that the result has unique elements
            if num in seen:
                res.append(num)
                seen.remove(num)
        
        return res
