# TC: O(log(m+n))
# SC: O(1)

class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        
        n1, n2 = len(nums1), len(nums2)
        if n1 > n2:
            return self.findMedianSortedArrays(nums2, nums1)
        
        start, end = 0, n1
        
        while start <= end:
            
            part1 = start + (end-start)//2
            part2 = (n1+n2)//2 - part1
            
            l1 = -float("inf") if part1 == 0 else nums1[part1-1]
            r1 = float("inf") if part1 == n1 else nums1[part1]
            l2 = -float("inf") if part2 == 0 else nums2[part2-1]
            r2 = float("inf") if part2 == n2 else nums2[part2]
            
            if (l1<=r2 and l2<=r1):
                return min(r1,r2) if (n1+n2)%2 else (max(l1,l2) + min(r1,r2))/2.0
            
            elif l1>r2:
                end = part1-1
            else:
                start = part1+1