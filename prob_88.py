# leetcode(275)
# Time - O(logn)
# space O(1)
#algo

class Solution(object):
    def hIndex(self, citations):
        """
        :type citations: List[int]
        :rtype: int
        """
        # binary search of the citations to find the index h
        # pointers variables initialization
        low = 0
        high = len(citations) - 1
        n = len(citations)
        # start binary search to find the approrpriate h index
        while low <= high:
            mid = (low + high) // 2
            diff = n - mid  # as the index starts with 0, here we get the remaining papers + 1  as n is length not indices
            num_citations = citations[mid]  # value at mid index
            if num_citations == diff:  # we found the exact value
                return diff
            elif num_citations < diff:
                low = mid + 1
            else:  # case when num_citations > diff
                high = mid - 1

        # print(low,mid,high)
        return n - low  # case when citations count matching not founf, we return low value-- refer to case [0,1,4,5,6]
