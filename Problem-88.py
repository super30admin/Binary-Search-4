#https://leetcode.com/problems/h-index-ii/
# Leetcode - 275 - H-index-11 
# Timecomplexity -O(LogN)
# Approach - Binary Search 

class Solution(object):
    def hIndex(self, citations):
        """
        :type citations: List[int]
        :rtype: int
        """
        low=0
        high=len(citations)-1
        n=len(citations)
        while low<=high:
            mid=low+(high-low)//2
            diff=n-mid
            midval=citations[mid]
            if midval==diff:
                return diff
            else:
                if midval<diff:
                    low=mid+1
                else:
                    high=mid-1
        return n-low # when in case binary condition fails 
                    

