"""
Approach: Make partitions in nums1 s.t. the partition in nums2 can be calculated on the fly 
since equal number of elements must be present in the left half of the partition and in the right 
half. The validity of the partition can be verified with the elements at the partition. we do a binary
search for the right partition using this information.
t.c. => O(nlogm)
s.c.=> O(1)

"""
class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        m, n = len(nums1), len(nums2)
        if n < m:
            return self.findMedianSortedArrays(nums2, nums1)
        
        l, r = 0, m
        while l <= r:
            part1 = l + (r - l)//2
            part2 = (m + n)//2 - part1
            
            x1 = nums1[part1 - 1] if part1 > 0 else float("-inf")
            x2 = nums2[part2 - 1] if part2 > 0 else float("-inf")
            y1 = nums1[part1] if part1 < m else float("inf")
            y2 = nums2[part2] if part2 < n else float("inf")
            if x1 <= y2 and x2 <= y1:
                return self.getMedian(m + n, x1, x2, y1, y2)
            elif x1 > y2:
                r = part1 - 1
            else:
                l = part1 + 1
        return 0
        
    def getMedian(self, totalLen, x1, x2, y1, y2):
        if totalLen % 2 ==0:
            return (max(x1, x2) + min(y1, y2))/2
        return min(y1, y2)