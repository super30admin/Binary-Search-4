class Solution:
    
    """
    
        Name : Shahreen Shahjahan Psyche
        Time : O(log N) [Sizee of Array]
        Space: O(1)
        
    
    """
    def hIndex(self, citations: List[int]) -> int:
        if not citations:
            return 0
        
        N = len(citations)
        
        low = 0
        high = len(citations)-1
        
        while(low <= high):
            mid = low + (high - low)//2
            diff = N - mid
            if citations[mid] == diff:
                return diff
            elif diff > citations[mid]:
                low = mid + 1
            else:
                high = mid -1
        
        return N-low
                         
