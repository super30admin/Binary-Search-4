class Solution:
    # Time Complexity: O(log(min(n1,n2)))
    # Space Complexity: O(1)

    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        n1 = len(nums1)
        n2 = len(nums2)
        if not n1 and not n2:
            return 0.0
        if n1 > n2:
            return self.findMedianSortedArrays(nums2, nums1)
        low = 0
        high = n1
        while low <= high:
            partX = (low + high) // 2
            partY = (n1 + n2) // 2 - partX
            L1 = -math.inf if partX == 0 else nums1[partX - 1]
            R1 = math.inf if partX == n1 else nums1[partX]
            L2 = -math.inf if partY == 0 else nums2[partY - 1]
            R2 = math.inf if partY == n2 else nums2[partY]
            if L2 <= R1 and L1 <= R2:
                if (n1 + n2) % 2 == 0:
                    return (min(R1, R2) + max(L1, L2)) / 2.0
                else:
                    return min(R1, R2)
            elif L2 > R1:
                low = partX + 1
            else:
                high = partX - 1
        return 0.0
