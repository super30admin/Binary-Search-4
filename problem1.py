#Solution 1:

Time complexity=O(n) where n= size of largest list
Space complexity=O(m) where m= size of smallest list

class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        if not nums1 or not nums2 or len(nums1)==0 or len(nums2)==0:
            return []
        
        if len(nums2)< len(nums2):
            nums1,nums2=nums2,nums1
        
        dic=dict()
        output=[]
        for i in nums1:
            if i not in dic:
                dic[i]=0
            dic[i]+=1
            
        for i in nums2:
            if i in dic:
                dic[i]-=1
                output.append(i)
                if dic[i]==0:
                    dic.pop(i)
        return output

#Solution 2:

Time complexity=O(nlogn) where n= size of largest list
Space complexity=O(1) 

class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        output=[]
        if not nums1 or not nums2 or len(nums1)==0 or len(nums2)==0:
            return output
        nums1.sort()
        nums2.sort()
        i=0
        j=0
        
        while i<len(nums1) and j<len(nums2):
            if nums1[i]==nums2[j]:
                output.append(nums1[i])
                i+=1
                j+=1
            elif nums1[i]<nums2[j]:
                i+=1
            else:
                j+=1
        return output
