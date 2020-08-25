class Solution(object):
    def hIndex(self, citations):
        n=len(citations)
        left=0
        right=n-1
        while left<=right:
            pivot=left+(right-left)//2
            if citations[pivot]==n-pivot:
                return n-pivot
            elif citations[pivot]<n-pivot:
                left=pivot+1
            else:
                right=pivot-1
        return n-left
#Time-complexity: O(logN)
#Space-complexity: O(1)