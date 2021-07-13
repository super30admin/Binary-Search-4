# TC: O(logN) :  
# SC: O(1) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution(object):
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        n1 = len(nums1)
        n2 = len(nums2)

        if n1 > n2:
            return self.findMedianSortedArrays(nums2, nums1)

        low = 0
        high = n1 # not n1 - 1 because we are looking at partitions not element
        while low <= high:
            part_x = low + (high - low)//2
            part_y = (n1 + n2)//2 - part_x

            l1 = -999999
            if part_x > 0:
                l1 = nums1[part_x - 1]

            r1 = 999999
            if part_x != n1:
                r1 = nums1[part_x]

            l2 = -999999
            if part_y > 0:
                l2 = nums2[part_y - 1]

            r2 = 999999
            if part_y != n2:
                r2 = nums2[part_y]

            if l1 <= r2 and l2 <= r1:
                #correct partition
                if (n1+n2) % 2 == 0:
                    return float(max(l1, l2) + min(r1, r2)) / 2
                else:
                    return min (r1, r2)

            elif l2> r1:
                low = part_x + 1
            else:
                high = part_x - 1
