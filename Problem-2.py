# approach 1: merge and find the median
"""
With 2 pointers, create a new merged list, get the median of the merged list
TC: O(n)
SC: O(n)
"""


class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        n1 = len(nums1)
        n2 = len(nums2)
        merged_num = []
        p1 = 0
        p2 = 0

        while p1 < n1 and p2 < n2:  # simultaneously iterate through each list
            if nums1[p1] < nums2[p2]:
                merged_num.append(nums1[p1])
                p1 += 1

            elif nums1[p1] > nums2[p2]:
                merged_num.append(nums2[p2])
                p2 += 1

            else:
                merged_num.append(nums1[p1])
                merged_num.append(nums2[p2])
                p1 += 1
                p2 += 1

        # get the rest of the elements
        while p1 < n1:
            merged_num.append(nums1[p1])
            p1 += 1

        while p2 < n2:
            merged_num.append(nums2[p2])
            p2 += 1

        if (n1 + n2) % 2 == 0:
            mid_right = merged_num[(n1 + n2) // 2]
            mid_left = merged_num[-1 + (n1 + n2) // 2]
            return (mid_right + mid_left) / 2

        else:
            return merged_num[(n1 + n2) // 2]

    # approach 2: binary search to find the right partition
    """

    TC:
    SC:
    """

    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        n1 = len(nums1)
        n2 = len(nums2)

        if n1 > n2:
            return self.findMedianSortedArrays(nums2, nums1)

        low = 0
        high = n1
        while low <= high:
            x_part = low + (high - low) // 2
            y_part = (n1 + n2) // 2 - x_part

            # handle endge cases and identify elements closest to partition
            l1 = float('-inf') if x_part == 0 else nums1[x_part - 1]
            r1 = float('inf') if x_part == n1 else nums1[x_part]
            l2 = float('-inf') if y_part == 0 else nums2[y_part - 1]
            r2 = float('inf') if y_part == n2 else nums2[y_part]

            if l1 <= r2 and l2 <= r1:  # correct partition found
                break
            elif l1 > r2:
                high = x_part - 1
            else:
                low = x_part + 1

        if (n1 + n2) % 2 == 0:
            return (max(l1, l2) + min(r1, r2)) / 2
        else:
            return min(r1, r2)