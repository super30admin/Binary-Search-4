# Time Complexity: O(m+n)
# Space Complexity: O(m) if m < n else O(n)
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        result = []
        
        # ensure nums1 is the smaller array always
        if(len(nums2) < len(nums1)):
            self.intersect(nums2, nums1)
        
        # hash map for smaller array nums 1
        hash_map = {}
        for num in nums1:
            if num not in hash_map:
                hash_map[num] = 1
            else:
                hash_map[num] += 1
        
        for num in nums2:
            if(num in hash_map):
                hash_map[num] -= 1
                result.append(num)
                
                if(hash_map[num] == 0):
                    del hash_map[num]
        
        return result
        