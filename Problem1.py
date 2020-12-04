# Time Complexity: O (log n)
# Space Complexity: O(1) 
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english:
# First I did H-index I problem. In that citations were not sorted.
# - Because this citations is sorted binary search can be used to find H-index.
# - I need to comare citations[i] with lengthOfCitations - i, and move to the left and right accordingly to the middle.
# - In the end return length of citation minus left.

class Solution(object):
    def hIndex(self, citations):
        """
        :type citations: List[int]
        :rtype: int
        """
        lenc = len(citations)
#       Initialize length of citations, left and right variable.
        left, right = 0, lenc - 1
#       Run while loop untill left and right cross overs.
        while left <= right:
#           calculate mid
            mid = left + right - left // 2
#           If citations[mid] is equal to lengthOfCitations minus mid than we found our h index.
            if citations[mid] == lenc - mid:
                return lenc - mid
#           If citations[mid] is less than lengthOfCitations minus mid than we need to shrink from left
            elif citations[mid] < lenc - mid:
                left = mid + 1
#           If citations[mid] is greater than lengthOfCitations minus mid than we need to shrink from right
            else:
                right = mid - 1
#       In the end return lengthOfCitations minus left.
        return lenc - left
        
        
