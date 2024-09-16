# // Time Complexity : O(log n)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

# Your approach: 
# Approach-1: As soon as the citations of current index is greater than or equal to the h-index, we can return it. We'll iterate from h-indices of length of arr and keep decreasing it by 1; or calculate it as length-index. -> O(n)
# Approach-2: O(logn) solution, binary search on the array of (length-index): If trial_hindex>citations@index, low=mid+1

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        
        low = 0
        high = len(citations)-1
        
        while low<=high:
            mid = low+(high-low)//2
            
            trialH_index = len(citations)-mid
            if trialH_index == citations[mid]:
                return trialH_index
            else:
                if trialH_index> citations[mid]:
                    low=mid+1
                else:
                    high=mid-1
        
        return len(citations)-low
        
