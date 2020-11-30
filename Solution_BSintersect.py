""""
TC=MlogN where N is the lendthe of the largest Array and M is len of smallest array
"""

class Solution_BSintersect:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        if(nums1==None or nums2==None or len(nums1)==0 and len(nums2)==0):
            return []
        res=[]
        n1=len(nums1)
        n2=len(nums2)
        if(n1>n2):
            return self.intersect(nums2,nums1)
        nums1.sort()
        nums2.sort()
        #print(nums1,nums2)
        idx=0
        for num in nums1:
            #print("target",num)
            bsIdx=self.binarysearch(nums2,idx,n2-1,num)
            if(bsIdx!=-1):
                res.append(num)
                #print(res)
                idx=bsIdx+1
        return res 
        
        
    def binarysearch(self,nums,low,high,target):
        #print(low,high,target)
        while(low<=high):
            mid=low+(high-low)//2
            if(nums[mid]==target):
                if(mid==low or nums[mid]>nums[mid-1]):
                    return mid
                else:
                    high=mid-1
            elif(nums[mid]>target):
                high=mid-1
            else:
                low=mid+1
        return -1
            
            
            
        
            
        