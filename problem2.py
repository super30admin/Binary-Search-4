class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        m = len(nums1)
        n= len(nums2)
        if(m==0 and n==0):
            return 0
        
        if(n<m):
            return self.findMedianSortedArrays(nums2,nums1)
        l = 0
        h = m
        
        while(l<=h):
            
            px = (l+h)//2
            py = (m+n)//2 -px
            if(px==0):
                l1 = -float('inf')
            else:
                l1 = nums1[px-1]
            if(px>=m):
                
                l2 = float('inf')
            else:
                l2 = nums1[px]
            if(py==0):
                r1 = -float('inf')
            else:
                r1 = nums2[py-1]
            if(py>=n):
                r2 = float('inf')
            else:
                r2 = nums2[py]
            if(l1<=r2 and r1<=l2):
                if(m+n)%2==0:
                    return (max(l1,r1) + min(l2,r2))/2
                else:
                    return min(l2,r2)
            
            elif(l1>r2):
                h=px-1
            else:
                l = px+1