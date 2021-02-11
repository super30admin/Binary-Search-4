#Time complexity:O(min(m,n))
#Space Complexity:O(1)
#approach:Find the partition position px and py which helps determine the two halfs left and right. L1 and l2 are the left pointers of left half of respective arrays
#r1 and r2 are the two right half pointers of the arrays.Move the pointers until a mid element is found. if the total number of elements are off return mid else return mid and its adjacent element /2
class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        n1=len(nums1)
        n2=len(nums2)
        if n1>n2:
            return self.findMedianSortedArrays(nums2,nums1)
        low=0
        high=n1
        while(low<=high):
            px=low+(high-low)//2
            py=(n1+n2)//2-px
            l1=-inf if px==0 else nums1[px-1]
            r1=inf if px==n1 else nums1[px]
            l2=-inf if py==0 else nums2[py-1]
            r2=inf if py==n2 else nums2[py]
            if(l1<=r2 and l2<=r1):
                if (n1+n2)%2==0:
                    return (max([l1,l2])+min([r1,r2]))/2
                else:
                    return min([r1,r2])
            elif(l2>r1):
                low=px+1
            else:
                high=px-1
        return -9923.00