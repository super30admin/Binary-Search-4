class Solution(object):
    def hIndex(self, citations):
        """
        :type citations: List[int]
        :rtype: int
        """
        # Time Complexity: O(n)
        # Space Complexity: O(1)

        # hIndex=0
        # n = len(citations)
        # for i in range(n):
        #     papers = n-i
        #     if papers<citations[i]:
        #         hIndex = max(hIndex, papers)
        #     else:
        #         hIndex = max(hIndex, citations[i])
        
        # return hIndex

##################################################################
        
        # Time Complexity: O(log(n))
        # Space Complexity: O(1)
        n= len(citations)
        left = 0
        right = n-1

        while left <= right:
            mid = (left+right)//2
            papers = n-mid
            if papers == citations[mid]:
                return papers
            elif papers < citations[mid]:
                right = mid-1
            else:
                left = mid+1
        
        return (n-left)
