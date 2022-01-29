# time complexity: O(m+n)
# space complexity: O(m)

class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        result=[]
        if nums1==None or nums2==None or len(nums1)==0 or len(nums2)==0: return result
        
        if len(nums1)>len(nums2):
            temp=nums1
            nums1=nums2
            nums2=temp
            
        hashmap={}
        
        nums1=sorted(nums1)
        nums2=sorted(nums2)
        
        p1=0
        p2=0
        print(nums1, nums2)
        while(p1<len(nums1) and p2<len(nums2)):
            if nums1[p1]==nums2[p2]:
                result.append(nums1[p1])
                p1+=1
                p2+=1
            elif nums1[p1]>nums2[p2]:
                p2+=1
            else:
                p1+=1
                
#         for i in nums1:
#             if i not in hashmap:
#                 hashmap[i]=1
#             else:
#                 hashmap[i]+=1
                
#         for j in nums2:
#             if j in hashmap and hashmap[j]>0:
#                 result.append(j)
#                 hashmap[j]-=1
                
        return result