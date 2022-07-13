"""
TC: O(log K)
"""
class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        if len(nums1) > len(nums2) :
            nums1, nums2 = nums2,nums1
        n1 = len(nums1)
        n2 = len(nums2)
        
        high , low = n1, 0
        
        while low <= high:
            x = (low+high) //2
            y = ((n1+n2)//2) - x
            l1 = -math.inf if x == 0 else nums1[x-1]
            l2 = -math.inf if y == 0 else nums2[y-1]
            r1 = math.inf if x == n1 else nums1[x]
            r2 = math.inf if y == n2 else nums2[y]
            
            if l1 <= r2 and l2 <= r1 :
                if (n1+n2)%2 == 0:
                    return (max(l1,l2) + min(r1,r2))/2
                else:
                    return min(r2,r1)
            elif l2 > r1 :
                low = x + 1
            else:
                high = x - 1
        
        return -1 
