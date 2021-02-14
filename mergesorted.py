class Solution:
    
    """
    Description: find median of two sorted arrays:
    
    Time complexity: O(n + m), n and m are dimensions of arrays
    Space complexity: O(n + m), to store merged sorted array
    
    Approach:
    1. merge by matching values until the array length (common)
    2. add remaining elements from whichever array is longer
    3. return median depending on array size is even or odd
    """
    
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        
        n = len(nums1); m = len(nums2)
        i = 0; j = 0; result = []
        
        while i < n and j < m:
            if nums1[i] < nums2[j]:
                result.append(nums1[i]); i += 1
            else:
                result.append(nums2[j]); j += 1
        
        # Store remaining elements
        while i < n: 
            result.append(nums1[i]); i += 1
  
        while j < m: 
            result.append(nums2[j]); j += 1
        
        if len(result) % 2 == 0:
            return (result[len(result)//2] + result[len(result)//2 - 1])/2
        else: return result[len(result)//2]
        
  # TODO: Optimized solution
