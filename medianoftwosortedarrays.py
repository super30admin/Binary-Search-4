# Time Complexity:(log(n1))
# Space Complexity: O(1)
class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        n1 = len(nums1)
        n2 = len(nums2)

        if n1 > n2:
            return self.findMedianSortedArrays(nums2, nums1)

        low = 0
        high = n1

        while low <= high:
            part_x = low + (high - low) // 2
            part_y = (n1 + n2) // 2 - part_x

            L1 = float('-inf') if part_x == 0 else nums1[part_x - 1]
            R1 = float('inf') if part_x == n1 else nums1[part_x]
            L2 = float('-inf') if part_y == 0 else nums2[part_y - 1]
            R2 = float('inf') if part_y == n2 else nums2[part_y]

            if L1 <= R2 and L2 <= R1:
                if (n1 + n2) % 2 == 0:
                    return (max(L1, L2) + min(R1, R2)) / 2
                else:
                    return min(R1, R2)
            elif L1 > R2:
                high = part_x
            else:
                low = part_x + 1

        return -1

