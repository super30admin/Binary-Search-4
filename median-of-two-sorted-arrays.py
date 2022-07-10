# Binary Search 
# TC: O(log(n1))
# SC: O(1)
class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        [1,2,3,4,5]
        if len(nums2)<len(nums1): return self.findMedianSortedArrays(nums2,nums1)
        n1=len(nums1)
        n2=len(nums2)
        l=0
        h=n1
        while(l<=h):
            px=l+(h-l)//2
            py=((n1+n2)//2)-px
            if px==0: l1=float('-inf')
            else: l1=nums1[px-1]
            if py==0: l2=float('-inf')
            else: l2=nums2[py-1]
            if px==n1: r1=float('inf')
            else: r1=nums1[px]
            if py==n2: r2=float('inf')
            else: r2=nums2[py]
            if l1<=r2 and l2<=r1:
                if (n1+n2)%2==0:
                    return ((min(r1,r2)+max(l1,l2))/2)
                else:
                    return min(r1,r2)
            elif l1>r2:
                h=px-1
            else:   
                l=px+1
