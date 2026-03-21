# problem 2 
# https://leetcode.com/problems/median-of-two-sorted-arrays/
class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        m = len(nums1)
        n = len(nums2)
        if m > n:
            return self.findMedianSortedArrays(nums2,nums1)
        # partition 1 = middle idx of nums1
        # partition 2 = (len(num1)+len(nums2)//2) - partition1
        low = 0 
        high = m 
        while low<=high:
            part1 = low + (high-low)//2
            part2 = ((m+n)//2) - part1 
            l1 = float('-inf') if part1 == 0 else nums1[part1-1]
            r1 = float('inf') if part1 == m else nums1[part1]
            l2 = float('-inf') if part2 == 0 else nums2[part2-1]
            r2 = float('inf') if part2 == n else nums2[part2]
            if l2<=r1 and l1<=r2:
                if (m+n) % 2 == 0:
                    return (max(l1,l2)+min(r1,r2)) / 2
                else:
                    return min(r1,r2)
            elif l1 > r2:
                high = part1
            else:
                low = part1+1
        return -1