"""Using merge sort"""
#Accepted on leetcode but not all test cases passing. I should debug floating point precision
#Time complexity - O(NlogN)
#Space omplexity - O(1)

class Solution(object):
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        #implementing merge sort on both arrays
        i = 0
        j = 0
        res = []
        while i < len(nums1) and j < len(nums2):
            if nums1[i] < nums2[j]:
                res.append(nums1[i])
                i += 1
            else:
                res.append(nums2[j])
                j += 1
            if i < len(nums1):
                res.append(nums1[i])
            if j < len(nums2):
                res.append(nums2[j])
        mid = len(res)//2
        if len(res) % 2 == 0:
            return (float(res[mid-1]+res[mid])/2)
        else:
            return float(res[mid])