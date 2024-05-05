"""
Difficult 

# Partition Problem 
https://www.youtube.com/watch?v=v3IK85IuNJU&list=PLWtKyKogBpBAnsRWmlBs2b1LpC98ikorf&index=31
"""

class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        if len(nums1) < len(nums2):
            # Do Binary Search of partition on nums1
            return self.binarySearch(nums1, nums2)
        else:
            # Do Binary Search of partition on nums2
            return self.binarySearch(nums2, nums1)
    
    def binarySearch(self, smallArray: List[int], bigArray: List[int]):
        low = 0
        high = len(smallArray)

        while low <= high:
            partX = int(low + (high - low)/2)
            partY = int((len(smallArray) + len(bigArray))/2) - partX
            # L1
            if partX == 0:
                l1 = float('-inf')
            else:
                l1 = smallArray[partX - 1]

            # L2
            if partY == 0:
                l2 = float('-inf')
            else:
                l2 = bigArray[partY - 1]

            # R1
            if partX == len(smallArray):
                r1 = float('inf')
            else:
                r1 = smallArray[partX]

            # R2
            if partY == len(bigArray):
                r2 = float('inf')
            else:
                r2 = bigArray[partY]

            if l1 <= r2 and l2 <= r1: #Take Care of edges
                if int(len(smallArray) + len(bigArray)) % 2 != 0:
                    # print ("r1=", r1)
                    return min(r1, r2)
                else:
                    # print ("r1=", r1, " l2=", l2)
                    return (min(r1, r2) + max(l1, l2)) /2
            elif l2 > r1:
                low = partX + 1
            elif l1 > r2:
                high = partX - 1