# Time Complexity: O(log(min(m,n)))
# Space Complexity: O(1)

class Solution(object):
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        if (len(nums1)) == 0 and len(nums2) == 0:
            return -1
        m, n = len(nums1), len(nums2)

        if n < m:
            return self.findMedianSortedArrays(nums2, nums1)

        l,h = 0, m
        while l <= h:
            partition_x = (h + l)//2
            partition_y = (m+n)//2 - partition_x
            x_left = float('-inf') if partition_x == 0 else nums1[partition_x-1]
            y_left = float('-inf') if partition_y == 0 else nums2[partition_y-1]
            x_right = float('inf') if partition_x == m else nums1[partition_x]
            y_right = float('inf') if partition_y == n else nums2[partition_y]
            if (x_left <= y_right and y_left <= x_right):
                if (n+m)%2 == 0:
                    return (max(x_left,y_left)+min(x_right,y_right)) / 2.0
                return min(x_right,y_right)
            if y_left > x_right:
                l = partition_x + 1
            elif x_left > y_right:
                h = partition_x - 1
        return -1
