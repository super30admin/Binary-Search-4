class Solution:
    def findMedianSortedArrays(self,nums1,nums2):
        def kth(a,b,k):
            la,lb=len(a),len(b)
            if la>lb:
                return kth(b,a,k)
            if la==0:
                return b[k-1]
            if k==1:
                return min(a[0],b[0])
            
            i=min(la,k//2)
            j=min(lb,k//2)
            if a[i-1]<=b[j-1]:
                return kth(a[i:],b,k-i)
            else:
                return kth(a,b[j:],k-j)
            
        total=len(nums1)+len(nums2)
        if total % 2 ==1:
            return kth(nums1,nums2,(total+1)//2)
        else:
            left=kth(nums1,nums2,total//2)
            right=kth(nums1,nums2,total//2+1)
            return (left+right)/2.0

if __name__=="__main__":
    sol=Solution()
    print(sol.findMedianSortedArrays([1,3],[2]))
    print(sol.findMedianSortedArrays([1,2],[3,4]))