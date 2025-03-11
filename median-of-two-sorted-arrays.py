
# Time O(log min(n1,n2))
# Space O(1)
import math
class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        n1 = len(nums1)
        n2 = len(nums2)
        if n1 > n2: return self.findMedianSortedArrays(nums2, nums1)
        n = n1 + n2
        low, high = 0, n1
        while low <= high:
            p1 = low + (high - low) // 2
            p2 = (n // 2) - p1 
            L1 = -math.inf if p1 == 0 else nums1[p1-1]
            R1 = math.inf if p1 == n1 else nums1[p1]
            L2 = -math.inf if p2 == 0 else nums2[p2 - 1] 
            R2 = math.inf if p2 == n2 else nums2[p2]
            if L1 <= R2 and L2 <= R1: 
                if n % 2 == 0:
                    return (max(L1, L2) + min(R1, R2)) / 2
                else: return min(R1, R2)
            elif L1 > R2:
                high = p1 - 1
            elif L2 > R1:
                low = p1 + 1
        return 0.0



# Time O(log min(n1,n2))
# Space O(1)
class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        n1 = len(nums1)
        n2 = len(nums2)
        if n1 > n2: return self.findMedianSortedArrays(nums2, nums1)
        if n1 == 0:
            mid = (n2 - 1) // 2
            if n2 % 2 == 0: 
                return (nums2[mid] + nums2[mid + 1]) / 2
            else: return nums2[mid]
        n = n1 + n2
        # using 2-pointers
        p1 = n1 // 2
        while p1 < n1:# todo
            p2 = (n // 2) - (p1+1) 
            L1 = -math.inf if p1 < 0 else nums1[p1]
            R1 = math.inf if p1 == n1-1 else nums1[p1 + 1]
            L2 = -math.inf if p2 == 0 else nums2[p2 - 1] 
            R2 = math.inf if p2 == n2 else nums2[p2]
            if L1 <= R2 and L2 <= R1: 
                if n % 2 == 0:
                    return (max(L1, L2) + min(R1, R2)) / 2
                else: return min(R1, R2)
            elif L1 > R2:
                p1 -= 1
            elif L2 > R1:
                p1 += 1
        return 0.0
        
