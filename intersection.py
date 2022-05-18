# Time Complexity : O(M+N) 
# Space Complexity : O(1) - as result is being returned it is not counted into space complexity
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        #Two pointer technique
        if len(nums2)>len(nums1):
            nums1,nums2=nums2,nums1
        nums1.sort()
        nums2.sort()
        t1=0
        t2=0
        result=[]

        while(t2<len(nums2) and t1<len(nums1)):
            if(nums1[t1]==nums2[t2]):
                result.append(nums1[t1])
                t1+=1
                t2+=1
            elif(nums1[t1]<nums2[t2]):
                t1+=1
            else:
                t2+=1

        return result
            
        
