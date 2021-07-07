'''
Solution:
1.  As the array is sorted, the (number of papers) with at least (number of citations) present
    at each index would be (N - index).
2.  There would be a sign flip at a particular index with (number of citations) >= (N - index).
3.  This location of sign flip can be found using either linear traversal or binary search.

Time Complexity:    O(n) - Linear Approach; O(logn) - Binary Search Approach
Space Complexity:   O(1) - both approaches

--- Passed all testcases successfully on Leetcode.
'''


class HIndex_BinarySearch:
    def hIndex(self, citations: List[int]) -> int:

        #   edge case check
        if (citations == None or len(citations) == 0):
            return 0

        #   initializations
        n = len(citations)
        lo = 0
        hi = n - 1

        #   iterate till low index and high index cross each other.
        while (lo <= hi):
            mid = lo + int((hi - lo) / 2)
            currCitations = citations[mid]
            leastCountGreater = n - mid

            #   this condition will be the least index where sign index happens for sure
            if (currCitations == leastCountGreater):
                return leastCountGreater

            #   this condition means that the location where sign flip happens lies ahead and so move low
            elif (currCitations < leastCountGreater):
                lo = mid + 1

            #   this condition means that the location where sign flip happens lies before and so move hi
            else:
                hi = mid - 1

        #   calculate N-index where index ends up at low, the location of first sign flip
        leastCountGreater = n - lo
        return leastCountGreater


class HIndex_Linear:
    def hIndex(self, citations: List[int]) -> int:

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