#Time - O(logn)
#Space- O(1)
#using binary search and h index citations 
# 0,1,3,5,6
# 5,4,3,2,1


class Solution:
    def hIndex(self, citations: List[int]) -> int:
        
        if not citations:
            return 0
        low = 0
        high = len(citations)-1
        n = len(citations)
    
        
        while low <= high:
            mid = (low + high)//2
            
            hInd = n-mid
            
            if citations[mid] == hInd:
                return hInd
            
            elif hInd > citations[mid]:
                low = mid + 1
            else:
                high = mid - 1
                
        return n - low
