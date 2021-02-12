# Created by Aashish Adhikari at 7:09 PM 2/8/2021

'''
Time Complexity:
O(NlogN) where N = m + n for sorting

Space Complexity:
O(1)


'''

class Solution(object):
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """

        nums1.extend(nums2)
        nums1.sort()
        leng = len(nums1)

        if leng % 2 != 0:
            mid = 1 + leng /2
            return nums1[mid-1]
        else:
            mid1 = (leng/2)-1
            mid2 = mid1 + 1
            return (nums1[mid1] + nums1[mid2])/2.

