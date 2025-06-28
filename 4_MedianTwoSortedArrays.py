"""
TC -> O(log(min(n1,n2)) where n1, n2 are the lengths
SC ->O(1)
"""
class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        if len(nums1) > len(nums2):
            nums1, nums2 = nums2, nums1

        n1 = len(nums1)
        n2 = len(nums2)
        l = 0
        h = n1
        while (l <= h):
            partX = l + (h - l) // 2
            partY = ((n1 + n2 + 1) // 2) - partX
            # updating the left border elements in left partition
            # updating the right border elements in right partition
            X1 = -float('inf') if partX == 0 else nums1[partX - 1]
            X2 = float('inf') if partX == n1 else nums1[partX]
            Y1 = -float('inf') if partY == 0 else nums2[partY - 1]
            Y2 = float('inf') if partY == n2 else nums2[partY]

            if X1 > Y2:
                # if X1 greater than Y2, partY should be increased which means partX
                # should be decreased and hence we reduce h
                h = partX - 1
            elif Y1 > X2:
                # if Y1 greater than X2, partY should be decreased which means partX
                # should be increased and hence we increase l
                l = partX + 1
            else:
                if ((n1 + n2) % 2 == 0):
                    # for even number of elements
                    return (max(X1, Y1) + (min(X2, Y2))) / 2
                else:
                    # for off number of elements
                    return max(X1, Y1)


