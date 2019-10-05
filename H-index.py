"""
The approach here is to keep seraching for the sub-array with no more than h citation each, as we do 
your normal binary search, at every mid index we check if the value at mid is less than len of arr - mid
index, so we know that non h citation elements are towards left of the mid, so we move our low towards right
like this we keep on doing this until low and high cross each other, and later once the low crosses the
mid we return length of the array - low.
Time complexity - O(N)
Space complexity - O(1)
 
"""

class Solution(object):
    def hIndex(self, citations):
        length = len(citations)
        low = 0
        high = length - 1
        while low <= high:
            mid = (low+high) // 2
            if citations[mid] < length - mid:
                low = mid + 1
            else:
                high = mid - 1
        return length - low 