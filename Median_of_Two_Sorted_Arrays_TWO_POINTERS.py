# Created by Aashish Adhikari at 1:27 PM 2/12/2021

'''
Time Complexity:
O(N/2) ~ O(N)

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

        N = len(nums1) + len(nums2)

        p1 = 0
        p2 = 0

        for idx in range(0, N):

            if N % 2 ==0 and idx == (N/2) - 1:
                break
            if N%2 == 1 and idx == (N/2):
                break
            if p1 < len(nums1) and p2<len(nums2):

                if nums1[p1]<= nums2[p2]:
                    p1 += 1
                else:
                    p2 += 1
            elif p1 < len(nums1):
                p1 += 1
            else:
                p2 += 1


        # we have (N/2) - 1 now

        # if even number of elements
        if N%2 == 0:
            first_mid = None
            second_mid = None

            # first mid
            if p1 < len(nums1) and p2<len(nums2):

                if nums1[p1] <= nums2[p2]:
                    first_mid = nums1[p1]
                    p1 += 1
                else:
                    first_mid = nums2[p2]
                    p2 += 1
            elif p1 < len(nums1):
                first_mid = nums1[p1]
                p1 +=  1
            else:
                first_mid = nums2[p2]
                p2 += 1


            # second mid
            if p1 < len(nums1) and p2<len(nums2):

                if nums1[p1] <= nums2[p2]:
                    second_mid = nums1[p1]
                else:
                    second_mid = nums2[p2]
            elif p1 < len(nums1):
                second_mid = nums1[p1]
                p1 +=  1
            else:
                second_mid = nums2[p2]
                p2 += 1



            return (first_mid + second_mid)/2.

        else:
            # odd number of elements
            if p1 < len(nums1) and p2<len(nums2):
                if nums1[p1] <= nums2[p2]:
                    return nums1[p1]
                else:
                    return nums2[p2]
            elif p1 < len(nums1):
                return nums1[p1]
            else:
                return nums2[p2]


