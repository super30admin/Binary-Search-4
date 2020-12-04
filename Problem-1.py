# Time Complexity :average O(logn)
# Space Complexity :O(1) 
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no
class Solution(object):
    def hIndex(self, citations):
        """
        :type citations: List[int]
        :rtype: int
        """
        #low and high of binary search
        low = 0
        high = len(citations) -1
        #total number of citation
        n = len(citations)
        while low <=high:
            #get mid
            mid = low + (high-low)/2
            #check if number of citation is equal than the sum of the rest of the papers if yes
            if citations[mid] == n-mid:
                #return total number of citation minus position of mid
                return n-mid
            # if number of citations more than total number of citation minus position of mid search left subarray
            elif citations[mid] > n-mid:
                high = mid -1
            # else search right subarray
            else:
                low = mid+1
        #return n-low
        return n-low
        