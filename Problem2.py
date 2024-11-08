# TC =  O( (m+n)log m ) | SC = O(1)

class Solution:
    def __setMinsAndMaxs(self, pX: int, pY: int, nums1: list[int], nums2: list[int]) -> tuple:

        if (pX == 0):
            maxLeftX = float('-inf')
        else:
            maxLeftX = nums1[pX - 1]

        if (pX == len(nums1)):
            minRightX = float('inf')
        else:
            minRightX = nums1[pX]

        if (pY == 0):
            maxLeftY = float('-inf')
        else:
            maxLeftY = nums2[pY - 1]

        if (pY == len(nums2)):
            minRightY = float('inf')
        else:
            minRightY = nums2[pY]

        return maxLeftX, maxLeftY, minRightX, minRightY
    def findMedianSortedArrays(self, nums1: list[int], nums2: list[int]) -> float:

        if (len(nums2) < len(nums1)):
            return self.findMedianSortedArrays(nums2, nums1)

        leftElements = int((len(nums1) + len(nums2) + 1) / 2)
        low = 0; high = len(nums1)

        while (low <= high):

            pX = low + int((high - low) / 2)
            pY = leftElements - pX

            maxLeftX, maxLeftY, minRightX, minRightY = self.__setMinsAndMaxs(pX, pY, nums1, nums2)

            if (maxLeftX <= minRightY and maxLeftY <= minRightX):

                if ((len(nums1) + len(nums2)) % 2 == 0):
                    return (max(maxLeftX, maxLeftY) + min(minRightX, minRightY)) / 2
                else:
                    return (max(maxLeftX, maxLeftY))

            elif (maxLeftX > minRightY):
                high = pX - 1

            else:
                low = pX + 1

        return 0.0