#  https://leetcode.com/problems/median-of-two-sorted-arrays/

class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        if len(nums1) > len(nums2):
            nums1, nums2 = nums2, nums1
        
        m,n = len(nums1), len(nums2)

        low = 0
        high = m 

        while low <= high:
            mid1 = low + (high - low) // 2
            mid2 = (m+n)//2 - mid1

            L1 = float('-inf') if mid1 == 0 else nums1[mid1-1]
            R1 = float('inf') if mid1 == m else nums1[mid1]
            L2 = float('-inf') if mid2 == 0 else nums2[mid2-1]
            R2 = float('inf') if mid2 == n else nums2[mid2]

            if L1<= R2 and L2 <= R1:
                if (m+n)%2 != 0:
                    #return max(L1,L2)  # odd
                    return min(R1,R2)
                return (max(L1,L2) + min(R1,R2)) /2 # even
            
            elif L1 > R2:
                high = mid1 - 1
            else:
                low = mid1 + 1

# TC: O(log(min(m,n)))
# SC:  O(1)