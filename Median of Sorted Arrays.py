# Time complexity : O(log(m+n))
# Space complexity : O(1)

# The code ran on Leetcode

# Find the correct partition point on nums1 using binary search. Make sure both partitions have equal size with a maximum difference of 1 and all elements in the left portion are smaller than the ones on the right portion.

class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        if len(nums2) < len(nums1):
            nums1, nums2 = nums2, nums1
        m = len(nums1); n = len(nums2)
        total = m+n
        l = 0; r = len(nums1)

        while l <= r:
            partX = (l+r)//2
            partY = (total//2) - partX

            l1 = -1*10**6 + 2 if partX == 0 else nums1[partX-1]
            r1 = 10**6 + 2 if partX == m else nums1[partX]
            l2 = -1*10**6 + 2 if partY == 0 else nums2[partY-1]
            r2 = 10**6 + 2 if partY == n else nums2[partY]

            if l1 <= r2 and l2 <= r1:
                # Correct Partition
                if total % 2 == 0:
                    return (max(l1, l2) + min(r1, r2))/2
                else:
                    return min(r1, r2)
            elif l2 > r1:
                l = partX + 1
            else:
                r = partX - 1
        return 0
            