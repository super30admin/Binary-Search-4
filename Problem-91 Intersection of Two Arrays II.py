# 350. Intersection of Two Arrays II
# https://leetcode.com/problems/intersection-of-two-arrays-ii/

# Logic: Iterate over the smaller list and store count in the hashmap. 
# Iterate over the other list and check in the hashmap, if the element 
# exists and the count is more than zero, add it to the result and then 
# reduce count in the hashmap.

# Time Complexity: O(n+m)
# Space Complexity: O(min(m,n))

class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        if not nums1 or not nums2:
            return []
        
        result = list()
        hashmap = dict()
        
        # Store count of nums1
        for i in nums1:
            if i in hashmap:
                hashmap[i] += 1
            else:
                hashmap[i] = 1
        
        for i in nums2:
            if i in hashmap and hashmap[i] > 0:
                result.append(i)
                hashmap[i] -= 1
        
        return result