"""
TC: O(log(min(N, M))) {We perform a binary search on the smaller array.  
                        Each step adjusts partition boundaries in constant time, 
                        resulting in logarithmic complexity based on the smaller input size.}
SC: O(1) {We use only pointer variables and temporary values for partition boundaries.  
           No extra data structures proportional to input size are used.}

Approach:
We are tasked with finding the median of two sorted arrays in optimal time.  
Instead of merging the arrays (which costs linear time), we use a binary search–based 
partitioning strategy on the smaller array.

Key idea:
We partition nums1 and nums2 such that:
    - The left half contains exactly half of all elements (or half + 1 if total is odd).
    - All elements in the left half are ≤ all elements in the right half.

Steps:
1. Ensure nums1 is the smaller array to minimize binary search range.
2. Perform binary search on nums1, choosing a partition index `partX`.
3. Compute corresponding partition `partY` in nums2 so left and right halves balance.
4. Identify the boundary values l1, r1 (from nums1) and l2, r2 (from nums2),  
   using ±∞ for out-of-bounds indices.
5. If l1 ≤ r2 and l2 ≤ r1, the correct partition is found:
       - If total length is odd: return max(l1, l2).
       - If even: return (max(l1, l2) + min(r1, r2)) / 2.
6. Otherwise, adjust the search space based on which boundary is invalid.

This binary-search-based approach guarantees optimal performance while ensuring the correct split.

This problem ran successfully on Leetcode.
"""
class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        
        n1, n2 = len(nums1), len(nums2)
        if n1 > n2:
            return self.findMedianSortedArrays(nums2, nums1)
        
        low, high = 0, len(nums1)

        while low <= high:

            partX = low + (high - low) // 2
            partY = ((n1+n2)//2) - partX

            l1, l2 = float('-inf'), float('-inf')
            r1, r2 = float('inf'), float('inf')
            
            if partX > 0:
                l1 = nums1[partX-1]
            if partY > 0:
                l2 = nums2[partY - 1]
            if partX < n1:
                r1 = nums1[partX]
            if partY < n2:
                r2 = nums2[partY]
            
            if l1 <= r2 and l2 <= r1:
                #found the correct partition
                if (n1 + n2) % 2 != 0:
                    #odd
                    return min(r1, r2)
                else:
                    #even
                    res = (max(l1, l2) + min(r1, r2))/2
                    return res


            if l1 > r2:
                high = partX - 1
            elif l2 > r1:
                low = partX + 1
            

