# Time Complexity : O(log(min(n1,n2)))
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

"""
Do binary search on partition of the smaller array and find the partition of the other array and
see if it is the correct partition.
"""

class Solution(object):
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """

        n1 = len(nums1)
        n2 = len(nums2)

        if n2 < n1:
            return self.findMedianSortedArrays(nums2, nums1)

        low = 0
        high = n1

        while low <= high:
            x_part = low + (high-low)//2
            y_part = (n1+n2)//2 - x_part

            l1 = float('-inf') if x_part == 0 else nums1[x_part-1]
            l2 = float('-inf') if y_part == 0  else nums2[y_part-1]
            r1 = float('inf') if x_part == n1 else nums1[x_part]
            r2 = float('inf') if y_part == n2 else nums2[y_part]

            if (l1 <= r2 and l2 <= r1):
                if (n1+n2)%2 == 0:
                    return (max(l1,l2) + min(r1,r2))/2.0
                else:
                    return min(r1,r2)
            elif l1 > r2:
                high = x_part - 1
            else:
                low = x_part + 1







