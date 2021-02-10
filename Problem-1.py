#Time Complexity :O(mlogn) n is size of larger array 
#Space Complexity :o(1) 
#Did this code successfully run on Leetcode :yes
#Any problem you faced while coding this :no
class Solution(object):
    def intersect(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        if(nums1==None or nums2==None):
            return []
        
        res=[]
        if(len(nums1)>len(nums2)):
            self.intersect(nums2,nums1)
            
        nums1.sort()
        nums2.sort()
        
        low,high=0,len(nums2)-1
        for i in range(len(nums1)):
            #print(nums1[i],low,high)
            ans=self.BS(nums2,low,high,nums1[i])
            if(ans!=-1):
                res.append(nums1[i])
                low=ans+1
                
    
        return res
    
    def BS(self,arr,low,high,target):
        while(low<=high):
            mid=low+(high-low)//2
            if(arr[mid]==target):
                if(mid==low or arr[mid]>arr[mid-1]):
                    return mid
                else:
                    high=mid-1
            elif(arr[mid]>target):
                high=mid-1
            else:
                low=mid+1
        return -1
                
        
        #2 pointer 
        #####
#         p1=0
#         p2=0
#         while(p1<len(nums1) and p2<(len(nums2))):
#             if(nums1[p1]==nums2[p2]):
#                 res.append(nums1[p1])
#                 p1+=1
#                 p2+=1
#             elif(nums1[p1]<nums2[p2]):
#                 p1+=1
#             else:
#                 p2+=1
            
        
#         return res
        
        #####