#Time m*O(logn) for BS, n*m for hashmap, two pointer m+n

class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        
        
     
      
        nums1.sort()
        nums2.sort()
        r=[]
        if len(nums1)>len(nums2):
            nums1,nums2=nums2,nums1
        l=0
        h=len(nums2)-1
        for i in range(len(nums1)):
            idx=self.bs(nums2,l,h,nums1[i])
            
            if idx!=-1:
                l=idx+1
                r.append(nums1[i])
            
        
        Two pointers
        l1=0
        l2=0
        r=[]
        while l1<len(nums1) and l2<len(nums2):
            if nums1[l1]==nums2[l2]:
                
                r.append(nums1[l1])
                l1+=1
                l2+=1
            elif nums1[l1]>nums2[l2]:
                l2+=1
            else:
                l1+=1
                
                
        
       Hashmap 
        h={}
        c=1
        r=[]
        for i in nums1:
            if i not in h.keys():
                h[i]=1
            else:
                h[i]+=1
                
        for i in nums2:
            if i in h.keys() and h[i]>0:
                r.append(i)
                h[i]-=1
                              
        return r
      
        #Binary Search
    
    def bs(self,arr,l,h,t):
  
        while l<=h:
            m=l+(h-l)//2
            
            if arr[m]==t:
                if arr[m]>arr[m-1] or m==l:
                    return m
                else:
                    h=m-1
            elif arr[m]>t:
                h=m-1
            else:
                l=m+1
                
        return -1
