# Time Complexity:- O(logn)
# Space:- O(1)
# Approach:- pivot=middle element. If citations[pivot]==n-pivot we found the element we are looking for, if citations[pivot]<n-pivot, Since the desired element should be greater than or equal to n-pivot we should find the element on the right side else we should look on the left side.
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        left=0
        length = len(citations)
        right= length-1
        while(left<=right):
            mid=(left+right)>>1
            if(citations[mid] == (length-mid)):
                return citations[mid]
            elif(citations[mid] > (length-mid)):
                right = mid - 1
            else:
                left = mid + 1
        return length - (right+1)