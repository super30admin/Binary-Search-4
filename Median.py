# Problem2 Median of Two Sorted Arrays (https://leetcode.com/problems/median-of-two-sorted-arrays)

class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        n1, n2 = len(nums1), len(nums2)
        
        if n1 > n2:
            nums1, nums2, n1, n2 = nums2, nums1, n2, n1

        low, high = 0, n1

        while low <= high:
            partitionX = (low + high) // 2
            partitionY = (n1 + n2 + 1) // 2 - partitionX

            maxX = float('-inf') if partitionX == 0 else nums1[partitionX - 1]
            minX = float('inf') if partitionX == n1 else nums1[partitionX]

            maxY = float('-inf') if partitionY == 0 else nums2[partitionY - 1]
            minY = float('inf') if partitionY == n2 else nums2[partitionY]

            if maxX <= minY and maxY <= minX:
                if (n1 + n2) % 2 == 0:
                    return (max(maxX, maxY) + min(minX, minY)) / 2
                else:
                    return max(maxX, maxY)

            elif maxX > minY:
                high = partitionX - 1
            else:
                low = partitionX + 1

# Time complexity: O(log(min(N1, N2)))
# Space complexity: O(1)