# Space Complexity: O(1)
# Time Complexity: O(log(min(n1, n2))) where n1, n2 are the lengths of the arrays nums1 and nums2
class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        INF = 10 ** 20
        n1 = len(nums1)
        n2 = len(nums2)

        if n1 > n2: 
            return self.findMedianSortedArrays(nums2, nums1)

        low = 0
        high = n1

        while low <= high: 
            mid = low + (high - low) // 2

            partx = mid

            party = (n1 + n2) // 2 - partx

            l1 = -INF if partx == 0 else nums1[partx-1]
            r1 = INF if partx == n1 else nums1[partx]
            l2 = -INF if party == 0 else nums2[party-1]
            r2 = INF if party == n2 else nums2[party]

            if l1 <= r2 and l2 <= r1: 
                # Found the partition 
                if (n1 + n2 )% 2 == 1:
                    return min(r1, r2)

                else: 
                    return (max(l1, l2) + min(r1, r2)) / 2
            elif l2 > r1: 
                low = partx + 1
            else: 
                high = partx - 1

