# Time Complexity: O(m+n)
# Space Complexity: O(min(m,n))
# Approach: Store counts of larger array in hashmap. Traverse over the second array and check if elements are present in hashmap. If they are present, add them to a result array and decrement count in hashmap.
from collections import Counter
class Solution(object):
    def intersect(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        # Build a hashmap out of the longer array to save space
        if len(nums1) > len(nums2):
            self.intersect(nums2, nums1)
        intersect_map = Counter(nums1)
        result = []
        
        for y in nums2:
            if y in intersect_map and intersect_map[y] > 0:
                result.append(y)
                intersect_map[y] -= 1
                
        return result
        