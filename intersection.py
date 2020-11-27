class Solution(object):
    def intersect(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        intersect_map = {}
        result = []
        for x in nums1:
            if x in intersect_map:
                intersect_map[x] += 1
            else:
                intersect_map[x] = 1
        
        for y in nums2:
            if y in intersect_map and intersect_map[y] > 0:
                result.append(y)
                intersect_map[y] -= 1
                
        return result
        