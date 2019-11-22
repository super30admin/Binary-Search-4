"""Binary search approach"""
#Accepted on leetcode
#Time complexity - O(logN)
#Space omplexity - O(1)


class Solution(object):
    def hIndex(self, citations):
        """
        :type citations: List[int]
        :rtype: int
        """
        left = 0
        right = len(citations) - 1
        size = len(citations)
        while left <= right:
            mid = left + (right - left)//2
            if citations[mid] == size - mid:
                return size - mid
            elif citations[mid] < size - mid:
                left = mid + 1
            else:
                right = mid - 1
        return size - left      