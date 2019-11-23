'''
Accepted on leetcode(4)
Time - O(logn), space - O(1)
'''


class Solution:
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        # 1. Declaring variables
        n1 = len(nums1)
        n2 = len(nums2)

        low = 0
        high = n1

        # shorter array is used for binary search partition, or else the code is failing for edge cases.
        if n1 > n2:
            return self.findMedianSortedArrays(nums2, nums1)

        # 2. Calculating partitions in list 1 and 2 and splitting the lists accordingly
        while low <= high:
            partX = low + (high - low) // 2
            partY = (n1 + n2 + 1) // 2 - partX

            L1 = float("-inf") if partX == 0 else nums1[partX - 1]
            R1 = float("inf") if partX == n1 else nums1[partX]
            L2 = float("-inf") if partY == 0 else nums2[partY - 1]
            R2 = float("inf") if partY == n2 else nums2[partY]

            # 3. Check if the partitions are correct and if not then reiterate and make them right
            if L1 <= R2 and L2 <= R1:  # if this condition satisfies then calculate median
                # length of combined list is even
                if (n1 + n2) % 2 == 0:
                    return (max(L1, L2) + min(R1, R2)) / 2
                else:
                    return max(L1, L2)

            elif L2 > R1:  # if L2 > R1 then move right L2 and left R1
                low = partX + 1
            else:  # if L1 > R2 then move right L1 and left R2
                high = partX - 1
        return -1
