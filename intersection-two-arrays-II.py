"""
Runtime Complexity:
O(m+n) - we traverse both the list 'm' as well as 'n'. We store the largest list elements in hashmap with count as value. We iterate the smaller list and check whether
the element is in the hashmap and append it to the result if it exixts and reduce count by 1 until 0.
Space Complexity: O(min(m,n)) - hashmap to compute the result.
Yes, the code worked on leetcode.
Issues while coding - No
"""
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        if len(nums1)>len(nums2):
            nums1, nums2 = nums2, nums1
        hash_map = {}
        
        for i in nums2:
            if i in hash_map:
                hash_map[i] = hash_map[i]+1
            else:
                hash_map[i] = 1
        result = []
        
        for i in nums1:
            if i in nums2 and hash_map[i]>0:
                result.append(i)
                hash_map[i] = hash_map[i]-1
           
        return result
        
                    
                
        
        
        
                