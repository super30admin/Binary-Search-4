# Time complexity : O(m+n)
# Space complexity : O(n) to maintain the hash map

# The code ran on Leetcode

# Maintain a hash map of smaller array. Iterate over the larger array, check if it is already present in the hash map. Add it to the result if map[n] > 0

class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        if len(nums1) < len(nums2):
            nums1, nums2 = nums2, nums1
        res = []
        map = {}
        # Get the counter hash map
        for n in nums2:
            if n in map:
                map[n] += 1
            else:
                map[n] = 1

        for n in nums1:
            if n in map and map[n] > 0:
                res.append(n)
                map[n] -= 1
        return res
        
