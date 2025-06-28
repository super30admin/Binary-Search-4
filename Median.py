# Time Complexity: O(log(min(m,n))), perform binary search over the smaller array size min(m,n)
# Space Complexity: O(1)
class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        if len(nums1) > len(nums2):
            nums1, nums2 = nums2, nums1

        n1 = len(nums1)
        n2 = len(nums2)

        low = 0
        high = n1
        while low <= high:
            partX = low + (high - low)//2
            partY = (n1+n2)//2 - partX

            X1 = float('-inf') if partX == 0 else nums1[partX - 1]
            Y1 = float('inf') if partX == n1 else nums1[partX]
            X2 = float('-inf') if partY == 0 else nums2[partY -1]
            Y2 = float('inf') if partY == n2 else nums2[partY]

            if X1 <= Y2 and X2 <= Y1:
                # Correct partition
                if (n1+n2) % 2 == 0:
                    # Even 
                    return (min(Y1, Y2) + max(X1, X2)) / 2
                else:
                    return min(Y1, Y2)
            elif(X1 > Y2):
                high = partX - 1
            else:
                low = partX + 1
