# TC: O(nlogn + mlogn)
# SC: O(1) auxiliary
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        l1=len(nums1)
        l2=len(nums2)

        if l1>l2:
            b,s=nums1,nums2
        else:
            s,b=nums1,nums2
        
        res=[]
        b.sort()
        s.sort()
        low=0
        high=len(b)-1
        for i in s:
            high=len(b)-1

            while low<=high:
                mid=(low+high)//2
                if b[mid]==i:
                    if mid==low or b[mid]>b[mid-1]:
                        res.append(i)
                        low=mid+1
                        break
                    else:
                        high=mid-1

                elif b[mid]<i:
                    low=mid+1
                
                else:
                    high=mid-1
        
        return res
                

            
