# Leetcode problem link : https://leetcode.com/problems/h-index-ii/
# Time Complexity:    O(logn) binary search
# Space Complexity:   O(1)
#  Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
'''
    Linear approach : BAsed on observation that as soon as the sign flips happen between the number of citations i.e value at an index and its prospective h-index value i.e. n- index then its the h-index value. Linearly calculate the h-index at runtime and return as soon as sign flips
    
    Binary Search : As the array is sorted, same condition can be used to find element using bianry search.

''' 
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        if (citations == None or len(citations) == 0):
            return 0

        n = len(citations)
        lo = 0
        hi = n - 1

        #   iterate till low index and high index cross each other.
        while (lo <= hi):
            mid = lo + int((hi - lo) / 2)
            currCitations = citations[mid]
            # h-index value for mid
            leastCountGreater = n - mid

            #   this will occur when hindex is exactly at this position
            if (currCitations == leastCountGreater):
                return leastCountGreater

            #   if current citations are still less then h-index is in the second half
            elif (currCitations < leastCountGreater):
                lo = mid + 1

            #   this condition means that the location where sign flip happens lies before and so move hi
            else:
                hi = mid - 1

        #   if low and high have crossed then low is the h-index, calculate h-index for index low by length - low index
        leastCountGreater = n - lo
        return leastCountGreater



    def hIndex_linear(self, citations: List[int]) -> int:

        #   edge case
        if (citations == None or len(citations) == 0):
            return 0

        #   initializations
        n = len(citations)

        #   traverse until you find the first flip
        for i in range(n):
            currCitations = citations[i]
            leastCountGreater = n - i

            #   return N-index wherever sign flip happens first
            if (currCitations >= leastCountGreater):
                return leastCountGreater

        return 0