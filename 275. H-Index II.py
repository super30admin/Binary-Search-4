# T = O(log(n))
# S = O(1)
# Approach:
# Find the difference in the papers and the number of citation for every elemnt
# Find the index at which the the difference crosses the no of citations(Using Binary search)
# if the mid citation is more than the difference then move the right pointer
# else move the left pointer


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