#Time complexity - O(logn)
#Space complexity - O(1)
#Works on leetcode - yes
#Approach - The idea is to do binary search to find the min index such that citations[i] >= len(citations) - i, 
#then the answer is len(citations)-i
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        n = len(citations)
        l,r = 0, n-1
        while l<=r:
            mid = (l+r)//2
            if citations[mid]>= n - mid:
                r = mid -1
            else:
                l = mid +1
        return n-l