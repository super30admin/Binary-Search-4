#Time O(logn), space O(1)
class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        n1=len(nums1)
        n2=len(nums2)
        INT_MIN, INT_MAX = -2**64, 2**64
        n=n1+n2
        if n1>n2:
            return self.findMedianSortedArrays(nums2,nums1)
        
        l=0
        h=n1
        
        lp=(n1+n2+1)//2
        
        while l<=h:
            #Left and right partition
            p1=(l+h)//2
            p2=lp-p1
            
            l1=nums1[p1-1] if p1>0 else INT_MIN
            r1=nums1[p1] if p1<n1 else INT_MAX
            l2=nums2[p2-1] if p2>0 else INT_MIN
            r2=nums2[p2] if p2<n2 else INT_MAX
            
            #Moving p1 left
            if l1>r2:
                h=p1-1
            #Moving p1 right
            elif l2>r1:
                l=p1+1
            else:
                #Even
                if n%2==0:
                    return (max(l1,l2) +min(r1,r2))/2
                #Old
                else:
                    return max(l1,l2)
