'''
Solution:
1.  The main idea for this problem is that partition both arrays in such a way that both chunks
    should either contain equal elements or left chunk having one element greater than right.
2.  When the maximum of left top chunk is less than minimum of right bottom chunk and 
    maximum of left bottom chunk is less than minimum of right top chunk => partitioned correctly.
3.  Perform binary search on shorter array to obtain partition indices.

Time Complexity:    O( (M+N)logM ) -- M is length of shorter array
Space Complexity:   O(1)

--- Passed all testcases successfully on Leetcode. 
'''


class Solution:

    def __setMinsAndMaxs(self, pX: int, pY: int, nums1: List[int], nums2: List[int]) -> tuple:

        #   set maximum of left top chunk
        if (pX == 0):
            maxLeftX = float('-inf')    #   negative infinity if index < 0
        else:
            maxLeftX = nums1[pX - 1]    #   last element in left top chunk

        #   set minimum of right top chunk
        if (pX == len(nums1)):
            minRightX = float('inf')    #   positive infinity if index > length
        else:
            minRightX = nums1[pX]       #   first element in right top chunk

        #   set maximum of left bottom chunk
        if (pY == 0):
            maxLeftY = float('-inf')    #   negative infinity if index < 0
        else:
            maxLeftY = nums2[pY - 1]    #   last element in left bottom chunk

        #   set minimum of right bottom chunk
        if (pY == len(nums2)):
            minRightY = float('inf')    #   positive infinity if index > length
        else:
            minRightY = nums2[pY]       #   first element in right bottom chunk

        #   return all partitioned values
        return maxLeftX, maxLeftY, minRightX, minRightY

    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:

        #   to perform binary search on shorter array
        if (len(nums2) < len(nums1)):
            return self.findMedianSortedArrays(nums2, nums1)

        #   initializations
        leftElements = int((len(nums1) + len(nums2) + 1) / 2)   #   size of left top + bottom
        low = 0; high = len(nums1)                              #   low and high for BS

        #   until low and high cross completely
        while (low <= high):

            #   pX acts as mid here and compute pY accordingly
            pX = low + int((high - low) / 2)
            pY = leftElements - pX

            #   set all partitioned mins and maxs
            maxLeftX, maxLeftY, minRightX, minRightY = self.__setMinsAndMaxs(pX, pY, nums1, nums2)

            #   breaking condition => compute median which is one of two possible ways
            if (maxLeftX <= minRightY and maxLeftY <= minRightX):

                if ((len(nums1) + len(nums2)) % 2 == 0):
                    return (max(maxLeftX, maxLeftY) + min(minRightX, minRightY)) / 2
                else:
                    return (max(maxLeftX, maxLeftY))

            #   if maximum of top left is greater than minimum of bottom right => push high before
            elif (maxLeftX > minRightY):
                high = pX - 1

            #   else push low forward
            else:
                low = pX + 1

        return 0.0


