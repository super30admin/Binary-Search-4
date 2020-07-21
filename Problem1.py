"""
// Time Complexity : o(logn)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

"""
class Solution(object):
    def hIndex(self, citations):
        """
        :type citations: List[int]
        :rtype: int
        """
        if not citations:
            return 0
        n = len(citations)
        l = 0
        h = len(citations) - 1
        
        while l <= h: #using binary search
            mid = l + (h - l) / 2
            
            if citations[mid] == n - mid: #if equal, difference is the h-index
                return n - mid
            
            elif citations[mid] < n - mid: # if smaller, move low pointer to mid + 1
                l = mid + 1  
            else:
                 h = mid - 1
                    
        return n - l #low pointer will be at correct location
        """
        BRUTE FORCE
        for i in range(len(citations)):
            diff = n - i
            print(n, i)
            if citations[i] >= diff:
                return diff
        return 0
        """