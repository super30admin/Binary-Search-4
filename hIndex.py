# Time Complexity : Add - O(log N)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
'''
1. Using Binary search to find cross over point
'''

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        
        if  not citations or len(citations) < 1:
            return 0
        
        low = 0
        high = len(citations)-1
        n = len(citations)
        while low <= high:
            
            mid = low + (high-low)//2
            
            if citations[mid] == n-mid:
                return n-mid
            
            elif citations[mid] < n-mid:
                low = mid + 1
            
            else:
                high = mid - 1
                
        return n-low
                
        
        