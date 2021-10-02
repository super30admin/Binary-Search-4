# // Time Complexity :O(mlogn),m smallest and n largest
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach





class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        if len(nums1)>len(nums2):
            nums1,nums2=nums2,nums1
        nums1=sorted(nums1)
        nums2=sorted(nums2)
        low=0
        high=len(nums2)-1
        result=[]
        for i in range(len(nums1)):
            x=self.binarysearch(nums2,low,high,nums1[i])
            
            if x is not -1:
                
                low=x+1
                
                result.append(nums2[x])
                
        return result
                
            
            
            
            
            
            
            
    def binarysearch(self,arr,low,high,target):
        while(low<=high):
            
            mid=(low+high)//2
            print(mid)
            if arr[mid]==target:
                
                if mid-1 >= low and arr[mid]==arr[mid-1]:
                
                    high=mid
                else:
                    return mid
            elif arr[mid]<target:
                low=mid+1
            else:
                high=mid-1
        return -1