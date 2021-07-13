# TC: O(M) - smaller array len
# SC: O(N) - hashmap
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach 1 - hashmap  of larger array
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        
        # to make sure nums1 is smaller array
        if len(nums1)>len(nums2): return self.intersect(nums2,nums1)
        
        #print(nums1)
        #print(nums2)
        n1 = len(nums1)
        n2 = len(nums2)
        hashmap = {}
        for i in range(n2):
            if nums2[i] in hashmap:
                hashmap[nums2[i]]+=1
            else:
                hashmap[nums2[i]]=1
        #print(hashmap)
        result = []   
        for i in range(n1):
            if nums1[i] in hashmap:
                hashmap[nums1[i]]-=1
                result.append(nums1[i])
                if hashmap[nums1[i]]==0:
                    hashmap.pop(nums1[i])
        return result
                




        