#Time Complexity : O(logn)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        low, high = 0, len(citations)-1
        n = len(citations)
        while low <= high:
            hInd = low + (high-low)//2
            #check if number of citations are equal to atleast h citations
            if citations[hInd] == n - hInd:
                return n - hInd
            elif citations[hInd] < n - hInd:
                low = hInd + 1
            else:
                high = hInd - 1

        return n - low
