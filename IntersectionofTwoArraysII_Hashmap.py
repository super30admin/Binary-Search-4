# TC: O(max(M,N)) where M is the length of nums1 and N is the length of nums2. 
# SC: O(min(M,N)) since we will be building a hashmap of the smaller length array. 

class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        if not nums1 or not nums2 or len(nums1) == 0 or len(nums2) == 0: 
            return 
        
        self.final = []
        
        if len(nums1) > len(nums2):
            return self.intersect(nums2, nums1)
            
#         assuming length of nums1 is smaller than nums2
        
        hmap = {}
        for i in range(len(nums1)): 
            if nums1[i] in hmap: 
                temp = hmap.get(nums1[i])
                hmap[nums1[i]] = temp + 1
            else: 
                hmap[nums1[i]] = 1
        
        for j in range(len(nums2)): 
            if nums2[j] in hmap: 
                self.final.append(nums2[j])
                temp = hmap.get(nums2[j])
                if temp - 1 == 0: 
                    hmap.pop(nums2[j])
                else: 
                    hmap[nums2[j]] = temp - 1
        
        return self.final
