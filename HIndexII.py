class Solution:
    # Solution 1 
    # Trail H-index ==> How many papers have citations >= ith paper
    # h-index != any value in array
    # When h-index = 2 ==> Do we have atleast 2 papers >= 2 citations ?
    # Time Complexity - O(N)
    # Space Complexity - O(1)
    def hIndex1(self, citations):
        n = len(citations)
        for idx, c in enumerate(citations):
            hIndex = n - idx
            if c >= hIndex:
                return hIndex
        return 0
    
    # Using binary search by calculating trail h-index
    # Time Complexity - O(logN)
    # Space Complexity - O(1)
    def hIndex2(self, citations):
        l = len(citations)
        start = 0
        end = l - 1
        while start <= end:
            mid = start + (end-start) // 2
            trail = l - mid
            if citations[mid] == trail:
                return trail
            elif trail > citations[mid]:
                start = mid + 1
            else:
                end = mid - 1
        return l - start


        