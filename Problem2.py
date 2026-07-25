## Problem2
# Median of Two Sorted Arrays (https://leetcode.com/problems/median-of-two-sorted-arrays)
class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        # ---------------------------------------------------------
        # Time Complexity: O(log(min(m, n)))
        #   - We perform binary search only on the smaller array.
        #   - m and n are the lengths of nums1 and nums2.
        # Space Complexity: O(1)
        #   - We only use a few integer variables for pointers, 
        #     requiring constant extra space.
        # ---------------------------------------------------------
        
        # Ensure that A is always the smaller array to optimize the binary search.
        # We only want to run binary search on the shorter array.
        if len(nums1) > len(nums2):
            A, B = nums2, nums1
        else:
            A, B = nums1, nums2

        nA = len(A)
        nB = len(B)
        total = nA + nB
        
        # 'half' represents the number of elements in the left partition of the merged array
        half = total // 2

        # Initialize pointers for binary search on array A
        l, r = 0, nA - 1

        while True:
            # pA is the partition index for A
            pA = (l + r) // 2
            
            # pB is the partition index for B. 
            # Total elements in left partitions of A and B must equal 'half'
            # We subtract 2 because pA and pB are 0-indexed indices.
            pB = half - pA - 2

            # Determine the boundary values around the partitions.
            # If the partition index is out of bounds, use infinity or negative infinity 
            # to ensure the condition checks still hold.
            leftA = A[pA] if pA >= 0 else float('-inf')
            rightA = A[pA + 1] if (pA + 1) < nA else float('inf')
            
            leftB = B[pB] if pB >= 0 else float('-inf')
            rightB = B[pB + 1] if (pB + 1) < nB else float('inf')

            # Check if we have found the correct partition:
            # All elements on the left of the partition are <= elements on the right
            if leftA <= rightB and leftB <= rightA:
                
                # If the total number of elements is odd, the median is the 
                # minimum of the right-side boundary elements.
                if total % 2:
                    return min(rightA, rightB)
                
                # If even, the median is the average of the maximum left-side element 
                # and the minimum right-side element.
                return (max(leftA, leftB) + min(rightA, rightB)) / 2
                
            # If A's left partition is too large, move the search range to the left half of A
            elif leftA > rightB:
                r = pA - 1
                
            # If A's left partition is too small, move the search range to the right half of A
            else:
                l = pA + 1