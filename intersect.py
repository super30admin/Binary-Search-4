class Solution:
    
    """
    Description: Given two arrays, write a function to compute their intersection
    
    Time Complexicity: O(m + n)
    Space Complexicity: O(m), where m is smaller array
    
    Approach:
    - Use hash table to create counts of items in smaller array
    - Progressively append resulting array by checking items in larger array by updating the hash table
    """
    
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        
        result = []
        if nums1 == None or nums2 == None: return result
        
        if len(nums1) > len(nums2):
            return self.intersect(nums2, nums1) 
        
        num_dict = {}
        if len(nums1) <= len(nums2):
            for item in nums1:
                if item in num_dict.keys():
                    num_dict[item] += 1
                else:
                    num_dict[item] = 1
            
        for item in nums2:
            if item in num_dict.keys():
                if num_dict[item] > 0:
                    result.append(item)
                    num_dict[item] -= 1
                    
        return result
        
        
    # Follow up questions
    1. Optimize if the arrays are sorted
    
    
