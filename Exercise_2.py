# S30 Problem #92 Median of Two Sorted Arrays
#LeetCode #4 https://leetcode.com/problems/median-of-two-sorted-arrays

# Author : Akaash Trivedi
# Time Complexity : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode :  Yes #
# Any problem you faced while coding this : No

# find the partition that will divide the arrays in equal halfs
# partition x and y should divide nums1 and nums2
# equal number of elements on left and right side of partition combined: party = (n1 + n2) / 2 - partx
# If find the coirrect partition (x1 < y2) and (x2 < y1) return median
# ..x1 | y1..
# ..x2 | y2..
# when x1 > y2  so move partition in nums1 towards left: high = partx - 1
# when x2 > y1 so move partition in nums1 towards right low = partx + 1
class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        n1 = len(nums1)
        n2 = len(nums2)
        if n1 > n2:
            return self.findMedianSortedArrays(nums2, nums1)
        low = 0
        high = n1
        while low <= high:
            # to avoid interger overflow
            partx = low + (high - low) // 2 # partition x or mid
            party = (n1+n2) // 2 - partx
            x1 = float("-inf") if partx == 0 else nums1[partx-1]
            y1 = float("inf") if partx == n1 else nums1[partx]
            x2 = float("-inf") if party == 0 else nums2[party-1]
            y2 = float("inf") if party == n2 else nums2[party]
            if x1 <= y2 and x2 <= y1:
                # correct partition
                if (n1+n2) % 2 == 0:
                    # even
                    return (max(x1, x2) + min(y1,y2)) / 2
                else:
                    # odd
                    return min(y1, y2)
            elif x1 > y2:
                high = partx - 1
            else:
                low = partx + 1
        return 1.0