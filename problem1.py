'''
Time Complexity: O(log n)
Space Complexity: O(1)
Did this code successfully run on Leetcode : Yes
Explanation: Use Binary search to find the h-index of the citation.
'''
class Solution:
    # Linear approach for citation
    def hIndexIterative(self, citations: List[int]) -> int:
        if citations == None or len(citations) == 0:
            return 0

        n = len(citations)

        for i in range(0, n):
            citation = citations[i]
            count = n - i

            if citation >= count:
                return count

        return 0

    def hIndex(self, citations: List[int]) -> int:
        if citations == None or len(citations) == 0:
            return 0

        n = len(citations)
        low = 0
        high = len(citations) - 1

        i = 0
        while low <= high:
            mid = int(low + (high - low) / 2)

            citation = citations[mid]
            count = n - mid
            if citation == count:
                return count

            if citation < count:
                low = mid + 1
            else:
                high = mid - 1

        return n - low

