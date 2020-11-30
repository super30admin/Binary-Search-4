"""
tC=O(m+n)
SC=O(m)-->length of smallest array 

Build hashmap with smallest array and iterate through largest array.

"""
class Solution_intersHash:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        if(nums1==None or nums2==None or len(nums1)==0 and len(nums2)==0):
            return []
        d={}
        li=[]
        n1=len(nums1)
        n2=len(nums2)
        if(n1>n2):
            return self.intersect(nums2,nums1)
        for num in nums1:
            if num in d:
                d[num]+=1
            else:
                d[num]=1
        for num in nums2:
            if num in d:
                li.append(num)
                d[num]-=1
                if(d[num]==0):
                    del d[num]
        return li
                
            
            
            
        
            
        