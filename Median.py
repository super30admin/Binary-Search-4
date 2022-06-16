# TC -O(log (m+n))
# SC - O(1)
class Solution(object):
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        # At any time we are trying to have (m+n)/2 elements for checking
        # if the elements in the partition are not sorted, we move the pointers accordingly.
        # Once they look sorted we find median

        l = 0
        if len(nums1) > len(nums2):
            nums1, nums2 = nums2, nums1
        h = len(nums1)
        m = len(nums1)
        n = len(nums2)

        while(l <= h):
            x = l + (h - l)/2
            y = ((m + n) / 2) - x

            # nums1. - 0 to mid - if mid is zero there are no elements to validate against to in the right. So float of -inf
            # nums2 - 0 to y

            l1 = float('-inf') if x == 0 else nums1[x - 1]
            r1 = float('inf') if x == m else nums1[x]
            l2 = float('-inf') if y == 0 else nums2[y - 1]
            r2 = float('inf') if y == n else nums2[y]

            if(l1 <= r2 and l2 <= r1):

                if (m+n) % 2 == 0:
                    print((max(l1, l2) + min(r1, r2)))
                    return (max(l1, l2) + min(r1, r2)) / 2.0
                else:
                    return min(r1, r2)
            elif l1 > r2:
                h = x - 1
            else:
                l = x + 1
        return 0.0
