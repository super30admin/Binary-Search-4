# time complexity is log(n), where n is the size of the input with less elements
# space complexity is o(1).
class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        if(len(nums1) > len(nums2)):
            return self.findMedianSortedArrays(nums2, nums1)
        low = 0
        high = len(nums1)
        n1 = len(nums1)
        n2 = len(nums2)
        while(low <= high):
            xp = low + (high - low)//2
            yp = (n1 + n2)//2 - xp
            l1 = float("-inf") if (xp == 0) else nums1[xp-1]
            r1 = float("inf") if (xp == n1) else nums1[xp]
            l2 = float("-inf") if (yp == 0) else nums2[yp-1]
            r2 = float("inf") if (yp == n2) else nums2[yp]
            if(l1 <= r2 and l2 <= r1):
                if((n1+n2)%2 != 0): #odd
                    return min(r1, r2)
                else:
                    return (max(l1, l2) + min(r1, r2))/2
            if(l1 > r2):
                high = xp - 1
            if(l2 > r1):
                low = xp + 1
        return 9.99
                
            
            
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
#         nums1.extend(nums2)
#         nums1.sort()
#         l = len(nums1)
        
#         if(l%2!=0):
#             k = int((l+1)/2)
#             median = nums1[k-1]
#         else:
#             i = int(l/2)
#             j = int((l-1)/2)
#             median = (nums1[i] + nums1[j])/2
#         return median
                
        