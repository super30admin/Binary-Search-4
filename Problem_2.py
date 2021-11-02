class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        n1, n2 = len(nums1), len(nums2)
        if n1 > n2:
            return self.findMedianSortedArrays(nums2, nums1)
        low, high = 0, n1
        while low <= high:
            partX = low + (high - low) // 2
            partY = (n1 + n2) //2 - partX
            L1 = -float(inf) if partX == 0 else nums1[partX-1]
            L2 = -float(inf) if partY == 0 else nums2[partY-1]
            R1 = float(inf) if partX == n1 else nums1[partX]
            R2 = float(inf) if partY == n2 else nums2[partY]
            if L1 <= R2 and L2 <= R1:
                # Correct Partition
                if (n1 + n2) % 2 == 0:
                    return (max(L1, L2) + min(R1, R2))/2
                else:
                    return min(R1, R2)
            else:
                if L2 > R1:
                    low = partX + 1     
                else:
                    high = partX - 1
                    
# Time Complexity: O(log(min(n1,n2)))
# Space Complexity: O(1)