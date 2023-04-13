class Solution:
    #tc-o(m+n),sc-o(m+n)
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        p1=0
        p2=0
        m=len(nums1)
        n=len(nums2)
        result=[]
        while(p1<m and p2<n):
            if nums1[p1]<=nums2[p2]:
                result.append(nums1[p1])
                p1+=1
            else:
                result.append(nums2[p2])
                p2+=1
        while(p1<m):
            result.append(nums1[p1])
            p1+=1
        while(p2<n):
            result.append(nums2[p2])
            p2+=1
        l = m+n
        mid=l//2
        print(result)
        print((l//2)-1)
        if l%2==0:
            print(result[l//2]+result[(l//2)-1])
            return (result[l//2]+result[(l//2)-1])/2
        else:
            return result[l//2]
            