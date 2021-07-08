"""
// Time Complexity : O(logn) n is length of shorter array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 

// Your code here along with comments explaining your approach
Algorithm Explanation
Idea is to find the index where we get the flip of sign for n - i as we can see 
in the iterative approach
So since wthe array is sorted we consider the n - mid as our target in the 
binary search and update the low and hi based on the following conditions
coutn = n - mid
a) citation[mid] = count
    return count

b) citation[mid] < count : lo:= mid + 1
c) citation[mid] > count : hi:= mid - 1

End of the loop, we return n - low
"""
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        n = len(citations)
        lo,hi = 0,n - 1
        while lo <= hi:
            mid = (lo + hi) // 2
            citation = citations[mid]
            count = n - mid
            if citation == count:
                return count
            elif citation < n - mid:
                lo = mid + 1
            else:
                hi = mid - 1
        return n - lo