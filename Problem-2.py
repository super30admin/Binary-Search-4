'''
    Time Complexity: O(log(min(m,n)))
    Space Complexity: O(1)
'''
class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        m = len(nums1)
        n = len(nums2)

        # swap if nums1 is longer
        if m > n:
            return self.findMedianSortedArrays(nums2, nums1)

        total_elements = m + n
        equal_elements = total_elements // 2

        low = 0
        high = m

        while low <= high: 
            mid = low + (high - low) // 2

            part_x = mid
            part_y = equal_elements - part_x

            l1 = nums1[part_x - 1] if part_x != 0 else float("-inf")
            l2 = nums2[part_y - 1] if part_y != 0 else float("-inf")
            r1 = nums1[part_x] if part_x != m else float("inf")
            r2 = nums2[part_y] if part_y != n else float("inf")

            if l1 <= r2 and l2 <= r1:
                # Correct Partition
                if total_elements % 2:
                    return min(r1, r2)
                else:
                    mid1 = max(l1, l2)
                    mid2 = min(r1, r2)

                    return (mid1 + mid2) / 2
            elif l1 > r2:
                high = mid - 1
            else:
                low = mid + 1