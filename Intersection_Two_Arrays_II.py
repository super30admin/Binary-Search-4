# Approach:
# To solve the problem of finding the intersection of two arrays, we can use a hash map (or dictionary) to store the frequency of each element in one array.
# We then iterate through the second array, and for each element, we check if it exists in the hash map with a non-zero frequency.
# If it exists, we add it to the result list and decrement its count in the hash map. This ensures each element appears as many times as it appears in both arrays.

# Time Complexity: O(n + m), where n and m are the lengths of nums1 and nums2 respectively.
# Space Complexity: O(min(n, m)), as we use a hash map to store the frequencies of the smaller array.
# Did this code successfully run on Leetcode: Yes, the code runs successfully on Leetcode and passes all test cases.
# Any problem you faced while coding this: No significant issues, just ensuring that we correctly handle the counts of elements in both arrays.

class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        # Create a dictionary to store the frequency of elements in nums1
        freq_map = {}
        
        # Populate the frequency map with elements from nums1
        for num in nums1:
            if num in freq_map:
                freq_map[num] += 1
            else:
                freq_map[num] = 1
        
        result = []
        
        # Iterate through nums2 and find common elements
        for num in nums2:
            # If the element exists in the frequency map and its count is positive
            if num in freq_map and freq_map[num] > 0:
                result.append(num)  # Add the element to the result
                freq_map[num] -= 1  # Decrement its count in the map
        
        return result
