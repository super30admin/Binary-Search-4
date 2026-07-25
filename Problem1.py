## Problem1 
# Intersection of Two Arrays II (https://leetcode.com/problems/intersection-of-two-arrays-ii/)
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        """
        Time Complexity: O(N + M)
        - N is the length of nums1 and M is the length of nums2.
        - Building the Counter takes O(N) time.
        - Iterating through nums2 takes O(M) time.
        - Dictionary lookups and appends are O(1) on average.
        
        Space Complexity: O(min(N, M))
        - By ensuring nums1 is always the smaller array, the Counter 
          hash map will only store at most min(N, M) elements.
        - (Note: Output array space is not counted towards space complexity)
        """
        n1, n2 = len(nums1), len(nums2)
        
        # LOGIC: Optimization step to ensure nums1 is always the smaller array.
        # This keeps our space complexity to O(min(N, M)) because we only build 
        # the hash map for the smaller array.
        if n2 < n1:
            return self.intersect(nums2, nums1) # Added the missing 'return' here!
        
        # LOGIC: Create a frequency map of the smaller array.
        # This tracks how many times each number appears.
        count = Counter(nums1)
        result = []
        
        # LOGIC: Iterate through the larger array to find intersecting elements.
        for i in range(n2):
            key = nums2[i]
            
            # LOGIC: If the number is in our map and its count is greater than 0,
            # it means we found a valid intersection.
            if count.get(key, 0) > 0:
                result.append(key) # Add to our result list
                count[key] -= 1    # Decrement the count to handle duplicate intersections
                
        return result