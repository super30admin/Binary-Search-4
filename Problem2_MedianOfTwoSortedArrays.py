# Time Complexity: O(logm), where m - length of the smaller array
# Space Complexity: O(1)

# Solution:

class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        if not nums1 and not nums2:
            return 0

        n1 = len(nums1)
        n2 = len(nums2)

        # Consider smaller array as nums1
        if n2 < n1:
            return self.findMedianSortedArrays(nums2, nums1)

        # Perform binary search on nums1
        low = 0
        high = n1

        while low <= high:
            # Partition the 2 arrays
            partX = low + (high - low) // 2
            partY = (n1 + n2) // 2 - partX

            # Assign left and right values from both partition
            l1 = float('-inf') if partX == 0 else nums1[partX - 1]
            l2 = float('-inf') if partY == 0 else nums2[partY - 1]
            r1 = float('inf') if partX == n1 else nums1[partX]
            r2 = float('inf') if partY == n2 else nums2[partY]

            # If they are partitioned such that the left values are less than or equal to the right values,
            # return the median
            if l1 <= r2 and l2 <= r1:
                if (n1 + n2) % 2 == 0:
                    return (max(l1, l2) + min(r1, r2)) / 2
                else:
                    return min(r1, r2)

            # Else, search for a better partition in left or right half
            elif l1 > r2:
                high = partX - 1
            else:
                low = partX + 1

        return -1

