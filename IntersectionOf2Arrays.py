class Solution:
    # Solution 1 - Using Hashmap 
    # M is length of nums1 and N is length of nums2
    # Time Complexity - O(M + N)
    # Space Complexity - O(min(M, N)) 
    def intersect1(self, nums1, nums2):
        result = []
        hashmap = {}
        for i in range(len(nums1)):
            if nums1[i] not in hashmap:
                hashmap[nums1[i]] = 0
            hashmap[nums1[i]] += 1
        for k in range(len(nums2)):
            if nums2[k] in hashmap and hashmap[nums2[k]] > 0:
                hashmap[nums2[k]] -= 1
                result.append(nums2[k])
        return result
    
                
        
        
        
                
        