'''
TC: O(log(min(m,n)))
SC: O(1)
'''
from typing import List

class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        if len(nums1) > len(nums2):
            nums1,nums2 = nums2,nums1
        l,r = 0,len(nums1)
        n1,n2 = len(nums1),len(nums2)
        while l<=r:
            mid = (l+r)//2
            part_y = ((n1+n2)//2) - mid
            l1 = -float('inf') if mid-1<0 else nums1[mid-1]
            l2 = -float('inf') if part_y-1<0 else nums2[part_y-1]
            r1 = +float('inf') if mid>=n1 else nums1[mid]
            r2 = +float('inf') if part_y>=n2 else nums2[part_y]
            if l1<=r2 and l2<=r1:
                if (n1+n2) %2 == 0:
                    return (max(l1,l2)+min(r1,r2))/2
                else:
                    return min(r1,r2)
            else:
                if l1>r2:
                    r = mid-1
                else:
                    l = mid+1
s = Solution()
print(s.findMedianSortedArrays([1,3],[2]))
print(s.findMedianSortedArrays([1,2],[3,4]))
print(s.findMedianSortedArrays([0,0],[0,0]))