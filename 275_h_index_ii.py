"""
Leetcode: https://leetcode.com/problems/h-index-ii/
Approach: Use Binary Search
Time Complexity: O(log n) because of binary search
Space Complexity: O(1), we only used pointers
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""


class Solution:
    def hIndex(self, citations: List[int]) -> int:
        n = len(citations)
        left = 0
        right = n- 1

        while left <= right:
            mid = left + (right - left) // 2

            if citations[mid] == n - mid:
                return n - mid

            elif citations[mid] < n - mid:
                # go to right
                left = mid + 1

            else:  # citation[mid] > n - mid:
                right = mid - 1

        # if left and right have crossed then left is the h-index, calculate h-index by length - left index
        return n - left