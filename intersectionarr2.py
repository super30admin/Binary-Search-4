"""350. Intersection of Two Arrays II
Time Complexity: nO(logm)
Space Complexity: O(n) n -> length of smallest array"""

#Binary search -> 2 modification 1. when the ele is found keep moving left ( to find the first occurance). 2. the change in search space -> start the search space from the next of first found ele. 
class Solution:
    
    def binarysearch(self,arr,low,high,target):
        while(low<=high):
            mid = low+(high-low)//2
            if arr[mid]==target:
                if mid == low or arr[mid]>arr[mid-1]:
                    return mid
                else:
                    high = mid-1
            elif (arr[mid]>target):
                high =mid-1
            else:
                low = mid+1
        return -1
                    
    
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        n1,n2 = len(nums1),len(nums2)
        if n1>n2:
            self.intersect(nums2,nums1)
        nums1.sort()
        nums2.sort()
        
        result = []
        
        low,high = 0,len(nums2)-1
        for i in range(len(nums1)):
            bs_index = self.binarysearch(nums2,low,high,nums1[i])
            if bs_index != -1:
                result.append(nums1[i])
                low = bs_index +1
        return result
                
            
           
            
   
            


"""approach -> use hashmap
Time Complexity :O(m+n)
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
  #use a hashset to store num and counts in smallest array. 
            
        #build hashmap on the smaller array
        if nums1>nums2:
            self.intersect(nums2,nums1)
        dict1 ={}
        for num in nums1:
            if num in dict1:
                dict1[num]+=1
            else:
                dict1[num]=1
            
                    
        result =[]
        for num in nums2:
            if num in dict1:
                count = dict1[num]
                if count>0:
                    result.append(num)
                    dict1[num]-=1
        return result"""
                    
                
                
                
            