# Runs on Leetcode
    # Runtime - O(logn) where n is length of array
    # Memory - O(1)

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        if not citations:
            return 0
        n = len(citations)
        low = 0
        high = n-1
        while low <= high:
            mid = low + (high-low)//2
            val = citations[mid]
            diff = n - mid
            if val == diff:
                return val
            elif val < diff:
                low = mid + 1
            else:
                high = mid - 1
        return n - low
