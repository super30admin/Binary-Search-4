#Time complexity: O(log(n1))
#space complexity: O(1)

class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        n1 = len(nums1)
        n2 = len(nums2)
        if n1 > n2:
            return self.findMedianSortedArrays(nums2, nums1)
        low = 0
        high = n1 
        
        while low <= high:
            xP = low + (high - low) // 2
            yP = ((n1+n2)// 2) - xP
            l1 = -sys.maxsize if xP == 0 else nums1[xP-1]
            l2 = -sys.maxsize if yP == 0 else nums2[yP-1]
            r1 = sys.maxsize if xP == n1 else nums1[xP]
            r2 = sys.maxsize if yP == n2 else nums2[yP]
            if l1 <= r2 and l2 <= r1:
                if (n1+n2) % 2 != 0:
                    return min(r1, r2)
                else:
                    return ((max(l1, l2) + min(r1, r2))/2)
            elif l2 > r1:
                low = xP + 1
            else:
                high = xP - 1
                
        
            
        
