# Time complexity - O(logn1), n1 length of array1.
#  Space complexity - O(1)
class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        if (len(nums1) > len(nums2)):
            return self.findMedianSortedArrays(nums2, nums1)

        start = 0
        end = len(nums1)

        X = len(nums1)
        Y = len(nums2)

        while start <= end:
            division1 = (start + end) // 2 
            division2 = (X + Y + 1) // 2 - division1

            if (division1 == 0):
                X1 = float('-inf')
            else:
                X1 = nums1[division1 - 1]

            if (division1 == len(nums1)):
                X2 = float('inf')
            else:
                X2 = nums1[division1]

            if (division2 == 0):
                Y1 = float('-inf')
            else:
                Y1 = nums2[division2 - 1]
            if (division2 == len(nums2)):
                Y2 = float('inf')
            else:
                Y2 = nums2[division2]

            if (X1 <= Y2 and Y1 <= X2):
                if (X + Y) % 2 == 0:
                    median = ((max(X1, Y1) + min(X2, Y2)) / 2)
                    return median
                else:
                    median = max(X1, Y1)
                    return median
            elif Y1 > X2:
                start = division1 + 1
            else:
                end = division1 - 1