'''
1. We use the idea that any element to the left of the median should be smaller than it and anything to the right is larger
2. We partition the smaller array to left and right and get the remaining left and right partitions using total merged array's length
3. We repeat the process of either increasing or decreasing the left/right partitions based on the conditions that anything in left partition should be less than the left most element in right partition and vice versa
4. If paritioned right, we either compute median as (avg of max ele from left p and min ele from right p) or just min of the right partition based on length of the merged array

TC: O(log(m+n))
SC: O(1)
'''

class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:


        total = len(nums1)+len(nums2)
        half = total//2

        A = nums1
        B = nums2

        if len(A)>len(B):
            A,B =B,A
        
        l = 0
        r = len(A)-1

        while(True):

            m = (l + r)//2
            # half - size of left partition
            j = half - 1 - (m + 1)

            # Left partition is upto mid if mid exists else we bound with -infinity
            AL = A[m] if m>=0 else -math.inf
            # Right partition is upto mid if mid exists else we bound with -infinity
            AR = A[m+1] if m+1<len(A) else math.inf
            BL = B[j] if j>=0 else -math.inf
            BR = B[j+1] if j+1<len(B) else math.inf

            # Check if we have partitioned the arrays correctly
            if AL<=BR and BL<=AR:
                return (min(BR,AR)+max(AL,BL))/2 if total%2==0 else min(BR,AR)
            elif AL>BR:
                r = m-1
            else:
                l = m+1