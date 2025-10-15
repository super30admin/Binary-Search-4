#Time: O(log(m+n)) as we are doing a binary search on the array of smaller length. We do that as our binary seach is more efficient.
#Space: O(1)

# The intuition is to find the partition where all the elements on the left is smaller than all the elements on the right and since its sorted array we can determine that by
# just having the 4 variables nums1Left, nums1Right, nums2Left, nums2Right. If the partition satisfies then we can calculate the median if its ODD or EVEN length

class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        if len(nums1) > len(nums2):
            nums1, nums2 = nums2, nums1

        low = 0
        high = len(nums1) - 1
        n = len(nums1) + len(nums2)

        while True:
            mid = low + (high - low) // 2

            nums1Left = nums1[mid] if mid >= 0 else float("-inf")
            nums1Right = nums1[mid + 1] if (mid + 1) < len(nums1) else float("inf")

            k = n // 2 - mid - 2

            nums2Left = nums2[k] if k >= 0 else float("-inf")
            nums2Right = nums2[k + 1] if (k + 1) < len(nums2) else float("inf")

            if nums1Right >= nums2Left and nums2Right >= nums1Left:  # Found the correct partition
                if n % 2 == 1:
                    return min(nums1Right, nums2Right)
                else:
                    val1 = max(nums1Left, nums2Left)
                    val2 = min(nums1Right, nums2Right)
                    return (val1 + val2) / 2

            elif nums1Right < nums2Left:
                low = mid + 1
            else:
                high = mid - 1
