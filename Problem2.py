"""
// Time Complexity : o(min(m,n)), where m and n are length of lists
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

"""
class Solution(object):
    def intersect(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        nums1 = sorted(nums1)#sort the lists
        nums2 = sorted(nums2)
        res = []
        ptr_1 = ptr_2 = 0 #place a pointers at the beginning of each list
        
        while ptr_1 < len(nums1) and ptr_2 < len(nums2):
            if nums1[ptr_1] == nums2[ptr_2]: #if values are same at both positions, add to result
                res.append(nums1[ptr_1])
                ptr_1 += 1
                ptr_2 += 1
            elif nums1[ptr_1] < nums2[ptr_2]: #else, increase the pointer for the one which is smaller
                ptr_1 += 1
            else:
                ptr_2 += 1
                
        return res