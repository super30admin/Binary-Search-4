class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        """
        Time complexity : O(log(min(n,m)))
        Space complexity : O(1)
        """
        
        n = len(nums1)
        m = len(nums2)
        
        if n > m:
            return self.findMedianSortedArrays(nums2,nums1)
        
        low = 0
        high = n
        
        while low <= high:
            mid = int((low + high)/2)
            partY = int((m+n)/2) - mid
            
            l1 = -10**7 if mid == 0 else nums1[mid-1]
            r1 = 10**7 if mid == n else nums1[mid]
            
            

            l2 = -10**7 if partY == 0 else nums2[partY-1]
            r2 = 10**7 if partY == m else nums2[partY]
            
            if r2 >= l1 and r1 >= l2:
                if (n+m)%2 == 0:
                    return (max(l1,l2) + min(r1,r2))/2
                else:
                    return min(r1,r2)
            elif r1 < l2:
                low = mid + 1
            else:
                high = mid - 1
        
            
            
            