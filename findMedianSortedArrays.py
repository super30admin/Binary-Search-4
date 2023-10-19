class Solution:
    def findMedianSortedArrays(self, nums1, nums2) -> float:
        if (len(nums1)) == 0 and len(nums2) == 0:
            return -1
        m = len(nums1)
        n = len(nums2)
        if n < m:
            return self.findMedianSortedArrays(nums2, nums1)
        l = 0
        h = m
        while l <= h:
            partx = (h + l)//2
            party = (m+n)//2 - partx
            l1 = float('-inf') if partx == 0 else nums1[partx-1]
            l2 = float('-inf') if party == 0 else nums2[party-1]
            r1 = float('inf') if partx == m else nums1[partx]
            r2 = float('inf') if party == n else nums2[party]
            if (l1 <= r2 and l2 <= r1):
                if (n+m)%2 == 0:
                    return (max(l1,l2)+min(r1,r2)) / 2.0
                return min(r1,r2)
            if l2 > r1:
                l = partx + 1
            elif l1 > r2:
                h = partx - 1
        return -1