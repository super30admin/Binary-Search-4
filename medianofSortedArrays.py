'''
Time Complexity --> O(m+n)

Space Complexity --> O(m+n)
'''
class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        res = []
        p1 = 0
        p2 = 0
        while p1<len(nums1) and p2<len(nums2):
            if nums1[p1]<=nums2[p2]:
                res.append(nums1[p1])
                p1+=1
            else:
                res.append(nums2[p2])
                p2+=1
        
        if p1>=len(nums1) and p2>=len(nums2):
            ind1 = len(res)//2
            if len(res)%2==0:
                ind1-=1
                ind2 = ind1+1
                return (res[ind1]+res[ind2])/2
            else:
                return res[ind1]

            
        elif p1>=len(nums1):
            while p2<len(nums2):
                res.append(nums2[p2])
                p2+=1
        else:
            while p1<len(nums1):
                res.append(nums1[p1])
                p1+=1
        print(res)
        ind1 = len(res)//2
        if len(res)%2==0:
            ind1-=1
            ind2 = ind1+1
            print(ind2)
            return (res[ind1]+res[ind2])/2
        else:
            return res[ind1]
        
        