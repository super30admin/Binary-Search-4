// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach:
The approach used here is for each and every citation we see whether the citation value is greater than or equal to n-index.we do this to check for sign flip as when ever we see a sign flip then n-index gives the h-index of the given problem.

# Time complexity --> o(logn)
# space complexity --> o(1)
class Solution(object):
    def hIndex(self, citations):
        """
        :type citations: List[int]
        :rtype: int
        """
        if citations==None or len(citations)==0:
            return 0
        n=len(citations)
        low=0
        high=n-1
        while low<=high:
            mid=low+(high-low)/2
            if citations[mid]==n-mid:
                return n-mid
            elif citations[mid]<n-mid:
                low=mid+1
            else:
                high=mid-1
        return n-low