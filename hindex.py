# Time Complexity: O(log n)
# Space complexity: O(1)
# Approach: Do binary search.
# The idea is, that the h-index will be the number when the value at the index is greater than or equal to length of the array minus the index
# we can do binary search of the number that is greater than or equal to the length - particular index.
# i.e, nums[mid] >= n - mid
# if greater or equal, move left side else move right side.
# return low at the end

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        n = len(citations)
        low = 0
        high = n-1
        while low <= high:
            mid = low +(high -low)//2
            if citations[mid] >= n - mid:
                high = mid -1
            else:
                low = mid + 1
        return n- low
                
            
            
        