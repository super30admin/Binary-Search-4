# Created by Aashish Adhikari at 7:29 PM 2/5/2021
'''
Time Complexity:
O(mlogm) to sort the longer array.
O(n) to traverse through the shorter array.
Hence. O(mlogm)

Space Complexity:
O(1) as sorting in done in-place.
'''

class Solution(object):
    def intersect(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """

        nums1.sort()
        nums2.sort()

        p1 = 0
        p2 = 0

        n1, n2 = len(nums1), len(nums2)


        result = []
        while p1 < n1 and p2 < n2:

            if nums1[p1] == nums2[p2]:
                result.append(nums1[p1])
                p1 += 1
                p2 += 1
            elif nums1[p1] < nums2[p2]:
                p1 +=1
            else:
                p2 += 1

        return result

