"""
Time Complexity : O(n) for a linear solution and O(logn) for the binary search solution
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


Your code here along with comments explaining your approach
I have 2solutions here. The commented one is linear solution. There, I just traverse through the array
and break where the number of papers left is less than than the citation on current paper. If that 
does not happen, I return 0. The same can be done with binary search. Here, we cannot break like we did
in linear search as almost everything to the right would be true. So we want to find the first location
when number of citations on current paper crossed number of remaining paper. This happend when left pointer
exceeds right pointer. After breaking we need to check if it it breaked because of this condition or
di this condition never occured and respectively we return the values.
"""


class Solution:
    def hIndex(self, citations: List[int]) -> int:
        if not citations:
            return 0
        n = len(citations)
        left = 0
        right = n-1
        while left < right:
            mid = left+(right-left)//2
            count = n-mid
            if citations[mid] >= count:
                right = mid
            else:
                left = mid+1
        if citations[right] >= n-right:
            return n-right
        return 0


# class Solution:
#     def hIndex(self, citations: List[int]) -> int:
#         if not citations:
#             return 0
#         l=len(citations)
#         for i in range(l):
#             if citations[i]>=l-i:
#                 return l-i
#         return 0
