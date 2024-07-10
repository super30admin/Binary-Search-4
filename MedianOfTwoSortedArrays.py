
# Time Complexity :
#  O(LOG(X)) , Where X = Min(M, N), M= lenght of 1st array, N = Length of 2nd array


# Space Complexity : 
#  O(1), since you are just searching, and returning the answer.


# Approach:
# Binary Search.
# First find the smaller of given arrays.
# Then assign block numbers to the smaller array and initiate left and right pointers pointing to 0th and last block of the smaller array.
# Accordingly calculate the partitionX and PartitionY values .
# Then proceed with normal binary search using those block numbers, until certain consitions are met.
# Return the median based on whether total elements are odd or even.


import sys
class Solution(object):
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        if not nums1 and not nums2:
            return -1
        
        # size of arrays
        m = len(nums1)
        n = len(nums2)
 
        # ensure that the first array is the shorter one
        if m>n:
            return self.findMedianSortedArrays(nums2, nums1)

        # Instead of indexes of the array, use the block numbers(0 and 1 encompass a '0' index, and so on)
        # perform binary search on smaller array, using block numbers
        low = 0
        high = m

        while low<=high:
            partX = (low+high) / 2    
            partY = ((m+n)/2) - partX
            if partX == 0:
                L1 = -10**6
            else:
                L1 = nums1[partX-1]
            if partX == m:
                R1 = 10**6
            else:
                R1 = nums1[partX]

            if partY == 0:
                L2 = -10**6
            else:
                L2 = nums2[partY-1]
            if partY == n:
                R2 = 10**6
            else:
                R2 = nums2[partY]


            # check the partition values
            if L1 <= R2 and L2 <= R1:
                #check if total no of elements is even
                if (m+n)%2 == 0:
                    return (max(L1, L2) + min(R1, R2)) / 2.0      # Note: 2.0 This makes float division possible.
                # else if odd
                return min(R1, R2)

            elif L1 > R2:
                # search in left of array
                high = partX-1

            else:
                # search in right of array
                low = partX+1
        

        return -1