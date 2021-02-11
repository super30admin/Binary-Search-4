#TC:O(min(m,n))
#SC:O(1)
#We find the partition position Px and Py which form basis for splitting the complete array in to 2 halfs left and right. l1, l2: left pointers of left halfs (last element of left arrays) r1, r2: right half pointers(first element of right arrays).
class Solution:
    def findMedianSortedArrays(self, nums1, nums2):
        n1=len(nums1)
        n2=len(nums2)
        if n1>n2:
            return self.findMedianSortedArrays(nums2,nums1)
        low, high= 0,n1
        while(low<=high):
            Px=low+(high-low)//2
            Py=(n1+n2)//2-Px
            l1=float('-inf') if Px==0 else nums1[Px-1]
            r1=float('inf') if Px==n1 else nums1[Px]
            l2=float('-inf') if Py==0 else nums2[Py-1]
            r2=float('inf') if Py==n2 else nums2[Py]
            if(l1<=r2 and l2<=r1):
                # even no of elements
                if (n1+n2)%2==0:
                    return (max([l1,l2])+min([r1,r2]))/2
                # odd
                else:
                    return min([r1,r2])
            elif(l2>r1):
                low=Px+1
            else:
                high=Px-1
        return "something"