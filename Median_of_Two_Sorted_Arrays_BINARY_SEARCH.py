# Created by Aashish Adhikari at 1:28 PM 2/12/2021

'''
Time Complexity:
O(logm) where m is the length of the shorted array.

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


        if len(nums2) < len(nums1):

            return self.findMedianSortedArrays(nums2, nums1)

        n1 = len(nums1)
        n2 = len(nums2)


        low = 0
        high = len(nums1) # do not do len(nums1)-1 as we will be doing the binary search on paritions, not elements

        import sys
        while low <= high:

            partition_X = low + ((high-low)/2) # parition_X acts as mid
            partition_Y = ((n1 + n2)/2 ) - partition_X


            # maintain l1, r2 different from partition_X and partition_Y to make sure you dont o out of the bounds
            l1 = nums1[partition_X-1] if partition_X != 0 else -1* sys.maxsize
            r1 = nums1[partition_X] if partition_X != n1 else sys.maxsize

            l2 = nums2[partition_Y-1] if partition_Y != 0 else -1* sys.maxsize
            r2 = nums2[partition_Y] if partition_Y != n2 else sys.maxsize


            # check if the partition is correct
            if l1 <= r2 and l2 <= r1:

                # if even numbers
                if (n1 + n2) % 2 == 0:
                    return (max(l1,l2) + min(r1,r2))/2.
                else:
                    return min(r1,r2)


            elif l2 > r1:
                low = partition_X + 1
            else:
                high = partition_X - 1


        return 1111.











