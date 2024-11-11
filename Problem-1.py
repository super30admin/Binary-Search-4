#Approach
# We need to find the partition in such way that the left marts rae less than the right parts of arrays
# if l2>r1 move right else move left


#Complexities
# Time: mlog(N)
# Space: O(1)


from typing import List


class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        if len(nums1) > len(nums2):
            return self.find_median(nums2, nums1)
        else:
            return self.find_median(nums1, nums2)

    def find_median(self, A1, A2):
        n1 = len(A1)
        n2 = len(A2)
        low = 0
        high = n1

        while low <= high:
            mid = (low + high) // 2

            part_x = mid
            part_y = (n1 + n2) // 2 - part_x

            l1 = float("-inf") if part_x == 0 else A1[part_x - 1]
            r1 = float("inf") if part_x == n1 else A1[part_x]

            l2 = float("-inf") if part_y == 0 else A2[part_y - 1]
            r2 = float("inf") if part_y == n2 else A2[part_y]

            if l2 <= r1 and l1 <= r2:
                if (n1 + n2) % 2 == 0:
                    return (max(l1, l2) + min(r1, r2)) / 2
                else:
                    return min(r1, r2)
            elif l1 < r2:
                low = mid + 1
            else:
                high = mid - 1
