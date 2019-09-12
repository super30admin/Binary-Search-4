# Time Complexity : O(log n)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode :Yes
# Any problem you faced while coding this : No


class Solution:
    def hIndex(self, citations: List[int]) -> int:

        l = 0
        length = len(citations)
        r = length - 1
        while l <= r:
            mid = (l + r) // 2
            if citations[mid] < length - mid:
                l = mid + 1
            else:
                r = mid - 1
        return length - l


# In this problem , I am doing binary search and am checking if the number is less that its index value from back, then
# I move my left to mid+1 else i will move my right to mid+1 and at last I will be at the index of valis citations and
# will  thus return the number of citations after that index.