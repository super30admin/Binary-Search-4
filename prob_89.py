#leetcode 350-
#time - O(log n)
class Solution(object):
    def intersect(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        # sort the arrays
        nums1 = sorted(nums1)
        nums2 = sorted(nums2)
        # we need 2 pointers and output array
        i = 0
        j = 0
        return_lst = []
        # iterate over the arrays , checking conditions
        while (i < len(nums1) and j < len(nums2)):
            val1 = nums1[i]
            val2 = nums2[j]
            if val1 == val2:
                return_lst.append(val1)
                i += 1
                j += 1
            elif val1 < val2:
                i += 1
            else:
                j += 1
        return return_lst
