
class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        n1 = len(nums1)
        n2 = len(nums2)

        if n1 > n2:
            # Fixed: Added self. and missing 's' to match the method name
            return self.findMedianSortedArrays(nums2, nums1)

        low = 0
        high = n1
        while low <= high:
            # Fixed: Used integer division (//) to avoid float indices
            partX = low + (high - low) // 2
            partY = (n1 + n2) // 2 - partX
            
            # Fixed: Converted C-style ternary operators (a ? b : c) to Python syntax (b if a else c)
            L1 = float('-inf') if partX == 0 else nums1[partX - 1]
            R1 = float('inf') if partX == n1 else nums1[partX]
            L2 = float('-inf') if partY == 0 else nums2[partY - 1]
            # Fixed: Changed nums1 to nums2 for the R2 partition
            R2 = float('inf') if partY == n2 else nums2[partY]

            if L1 <= R2 and L2 <= R1:
                if (n1 + n2) % 2 == 0:
                    return (min(R1, R2) + max(L1, L2)) / 2.0
                else:
                    return min(R1, R2)
            elif L2 > R1:
                low = partX + 1
            else:
                high = partX - 1