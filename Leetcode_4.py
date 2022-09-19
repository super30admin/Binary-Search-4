#Time Complexity: O(log min(m,n))
#Space Complexity: O(1)
class Solution:
    def findMedianSortedArrays(self, nums1, nums2) :
        n1=len(nums1)
        n2=len(nums2)
        if n1>n2:
            return self.findMedianSortedArrays(nums2,nums1)
        l=0
        r=n1
        
        while l<=r:
            par1=(l+r)//2
            par2=(n1+n2+1)//2-par1
            maxLeft1=-2**31 if par1==0 else nums1[par1-1]
            maxLeft2=-2**31 if par2 ==0 else nums2[par2-1]
            minRight1=2**31-1 if par1==n1 else nums1[par1]
            minRight2=2**31-1 if par2==n2 else nums2[par2]
            if maxLeft1<=minRight2 and maxLeft2 <= minRight1:
                return (max(maxLeft1, maxLeft2) + min(minRight1, minRight2))*0.5 if (n1+n2)%2==0 else max(maxLeft1, maxLeft2)
            elif maxLeft1>minRight2:
                r=par1-1
            else:
                l=par1+1
                
