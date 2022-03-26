# Time Complexity : O(nlog m )
 # Space Complexity : O(1)
 # Did this code successfully run on leetcode : Yes
 # Any problem you faced while coding this : No

class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        
        n1 = len(nums1)
        n2 = len(nums2)
        if n1 == 0 or n2==0 : return []
        if (n1 >n2): self.intersect(nums2, nums1)
        nums1.sort()
        nums2.sort()
        low,high =0,n2-1
        result=[]
        
        for num in nums1:
            index = self.binaryS(num,nums2, low,high)
            # low+=1
            if index!=-1:
                result.append(num)
                low = index +1
        return result
    
    def binaryS(self, n:int, nums: List[int],l:int ,h:int)  :
        # low =l
        
        while (l<=h):
            mid = int(l+(h-l)/2)
            if(nums[mid]==n):
                if(mid == l or nums[mid]!= nums[mid-1]):
                    return mid
                else:
                    h =mid-1
            elif(nums[mid]>n):
                h =mid-1
            else:
                l = mid+1
        return -1
         
            
            
            
            
            
        