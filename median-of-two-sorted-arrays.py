#TC: O(lg(min(m,n)))
#SC: O(1)
class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        m,n = len(nums1), len(nums2)
        if m > n: return self.findMedianSortedArrays(nums2, nums1)

        l,r = 0, m
        while True:
            partX = int(l + (r-l)//2)
            l1 = nums1[partX-1] if partX>0 else -float('inf')
            r1 = nums1[partX] if partX<m else float('inf')

            partY = int((m+n)//2 - partX)
            l2 = nums2[partY-1] if partY>0 else -float('inf')
            r2 = nums2[partY] if partY<n else float('inf')

            if l1 > r2:
                r = partX - 1
            elif l2 > r1:
                l = partX + 1
            else:
                return min(r1, r2) if (m+n)%2 != 0 else (max(l1,l2)+min(r1,r2))/2

        return -1