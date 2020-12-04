"""Two pointers approach"""
#Accepted on Leetcode
#Time complexity - O(m+n)
#Space complexity - O(1)

class Solution(object):
    def intersect(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        first = 0
        sec = 0
        res = []
        nums1.sort()
        nums2.sort()
        while first < len(nums1) and sec < len(nums2):
            if nums1[first] == nums2[sec]:
                res.append(nums1[first])
                first += 1
                sec += 1
            elif nums1[first] > nums2[sec]:
                sec += 1
            else:
                first += 1
        return res
