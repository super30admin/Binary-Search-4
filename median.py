# Time complexity: O((m + n) log (m + n))
# Space complexity: O(m + n)

import heapq

class MedianFinder:
    def __init__(self):
        self.max_heap = []
        self.min_heap = []

    def add_num(self, num):
        if not self.max_heap or num <= -self.max_heap[0]:
            heapq.heappush(self.max_heap, -num)
        else:
            heapq.heappush(self.min_heap, num)

        # Balance heaps
        if len(self.max_heap) > len(self.min_heap) + 1:
            heapq.heappush(self.min_heap, -heapq.heappop(self.max_heap))
        elif len(self.min_heap) > len(self.max_heap):
            heapq.heappush(self.max_heap, -heapq.heappop(self.min_heap))

    def find_median(self):
        if len(self.max_heap) > len(self.min_heap):
            return -self.max_heap[0]
        else:
            return (-self.max_heap[0] + self.min_heap[0]) / 2

def findMedianSortedArrays(nums1, nums2):
    median_finder = MedianFinder()
    for num in nums1 + nums2:
        median_finder.add_num(num)
    return median_finder.find_median()




# Use Binary Search
# Time complexity: O(log (min(m, n)))
# Space complexity: O(1)

def findMedianSortedArrays(nums1, nums2):
    """Return the median of two sorted arrays."""
    # Ensure nums1 is the smaller array
    if len(nums1) > len(nums2):
        nums1, nums2 = nums2, nums1

    x, y = len(nums1), len(nums2)
    left = 0
    right = x

    while left <= right:
        partitionX = (left + right) // 2
        partitionY = ((x + y + 1) // 2) - partitionX

        maxLeftX = float('-inf') if partitionX == 0 else nums1[partitionX - 1]
        minRightX = float('inf') if partitionX == x else nums1[partitionX]

        maxLeftY = float('-inf') if partitionY == 0 else nums2[partitionY - 1]
        minRightY = float('inf') if partitionY == y else nums2[partitionY]

        if maxLeftX <= minRightY and maxLeftY <= minRightX:
            if (x + y) % 2 == 0:
                return (max(maxLeftX, maxLeftY) + min(minRightX, minRightY)) / 2
            else:
                return max(maxLeftX, maxLeftY)
        elif maxLeftX > minRightY:
            right = partitionX - 1
        else:
            left = partitionX + 1


