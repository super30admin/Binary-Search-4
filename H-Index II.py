# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

#hash map and two pointers can also be used

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        low = 0
        high = len(citations) - 1
        while low <= high:
            mid = (low+high) // 2
            diff = len(citations) - mid
            if citations[mid] == diff:
                return diff
            if citations[mid] < diff:
                low = mid + 1
            else:
                high = mid - 1
        return len(citations) - low