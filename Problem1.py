## Problem1 
# Intersection of Two Arrays II (https://leetcode.com/problems/intersection-of-two-arrays-ii/)

# Approach
# Traverse through the smaller list and add all elements frequency to hashmap
# Traverse through larger list and if the element is present in hashmap, reduce freq by 1 and add it to res list. if freq == 0, remove it from hashmap
# return res. 

# Time Complexity: O(m+n)
# Space Complexity : O(min(m,n))
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        res = []
        hmap = {}
        n1 = len(nums1)
        n2 = len(nums2)

        if n1 > n2:
            self.intersect(nums2,nums1)

        for i in nums1:
            if i in hmap:
                hmap[i] += 1
            else:
                hmap[i] = 1
        
        for j in nums2:
            if j in hmap:
                res.append(j)
                hmap[j] -= 1
                if hmap[j] == 0:
                    del hmap[j]
        
        return res