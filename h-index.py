
#Time Complexity: O(logN)
#Space Complexity: O(1)
#Run on Leetcode: Yes
#Any Issues: No

class Solution:
    def hIndex(self, citations):
        
        n = len(citations)
        left, right = 0, n - 1
        while left <= right:
            pivot = left + (right - left) // 2
            if citations[pivot] == n - pivot:
                return n - pivot
            elif citations[pivot] < n - pivot:
                left = pivot + 1
            else:
                right = pivot - 1
        
        return n - left