"""
    // Time Complexity :T = O(log n)
    // Space Complexity :O(1)
    // Did this code successfully run on Leetcode : YES
    // Any problem you faced while coding this : NA
    // Explanation:
    #brute force -> T = O(n)
    iterate over citations, calculate diff
    if diff > value; return difference
    else return citations[i]

    # use binay search- > T = O(log n)
    diff = n - mid
    compare diff and mid
    update low and high pointers accordingly
    mistake: avoid returning citations[low]
"""
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        if len(citations)== 0 or citations is None:
            return 0

        low = 0
        high = len(citations)
        n = len(citations)
        while( low <= high):
            mid =int((low+high)/2)
            diff = n - mid
            if diff == citations[mid]:
                return diff
            elif diff > citations[mid]:
                low = mid + 1
            else:
                high = mid - 1
        return n - low


"""
    # brute force 
    #T = O(n)
    def hIndex(self, citations: List[int]) -> int:
        if len(citations)== 0 or citations is None:
            return 0

        n = len(citations)
        for i in range(n):
            diff = n - i
            value = citations[i]
            if value >= diff:
                return diff
        return n - low
"""
