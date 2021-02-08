#time: O(n+m)
#space: O(min(n,m))

#hashmap approach
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        if(nums1==[] or nums2==[]):
            return []
        hashmap={}
        n=len(nums1)
        m=len(nums2)
        result=[]
        if(n<m):
            num1=nums1
            num2=nums2
        else:
            num1=nums2
            num2=nums1
            
        for i in num1:
            if i not in hashmap:
                hashmap[i]=1
            else:
                hashmap[i]+=1
            
        for i in num2:
            if i in hashmap:
                if(hashmap[i]>0):
                    hashmap[i]-=1
                    result.append(i)
        return result
                
        
        
        