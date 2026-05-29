class Solution:
    def findMedianSortedArrays(self, nums1, nums2):
        m = len(nums1)
        n = len(nums2)
        merged = [0] * (m + n)

        p1 = 0
        p2 = 0
        idx = 0

        while p1 < m and p2 < n:
            if nums1[p1] < nums2[p2]:
                merged[idx] = nums1[p1]
                p1 += 1
            else:
                merged[idx] = nums2[p2]
                p2 += 1
            idx += 1

        while p1 < m:
            merged[idx] = nums1[p1]
            p1 += 1
            idx += 1

        while p2 < n:
            merged[idx] = nums2[p2]
            p2 += 1
            idx += 1

        idx = (m + n) // 2
        if (m + n) % 2 != 0:
            return merged[idx]
        else:
            return (merged[idx] + merged[idx - 1]) / 2.0

# Time: O(m + n)
# Space: O(m + n)