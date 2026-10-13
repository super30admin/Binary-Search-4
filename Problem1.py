# Problem1: Intersection of Two Arrays II (https://leetcode.com/problems/intersection-of-two-arrays-ii/)
# Time Complexity: O(m log m + n log n) for sorting both arrays, plus O(m log n) for the binary searches,
# where m = len(smaller array) and n = len(larger array).
# Space Complexity: O(1) extra space, since sorting is done in place (result is the output and not counted).
# Approach:
# Sort both arrays, and make nums1 the smaller one.
# For each number in nums1, binary search nums2 for its leftmost match, starting from "low".
# If found, add it to result and move low to just after the match.
# This uses up that copy, so duplicates are matched one by one and each element of nums2 is used only once.
class Solution:
    def intersect(self, nums1: list[int], nums2: list[int]) -> list[int]:
        n1 = len(nums1)  # length of first array
        n2 = len(nums2)  # length of second array

        # keep nums1 as the smaller array, so we loop over the small one and search the big one
        if n1 > n2:
            return self.intersect(nums2, nums1)

        result = []  # stores the common elements

        nums1.sort()  # sorted nums1 means matches move forward in nums2
        nums2.sort()  # binary search needs nums2 sorted

        low = 0  # start of the search range in nums2 (only moves forward)
        high = n2 - 1  # end of the search range in nums2 (never changes)

        for num in nums1:
            # find the leftmost index of num in nums2[low..high], or -1
            bs_index = self.binarysearch(nums2, num, low, high)
            if bs_index != -1:
                result.append(num)  # common element found, keep it
                low = bs_index + 1  # skip the used element so it is not matched again

        return result  # all common elements, with correct counts

    def binarysearch(self, nums, target, low, high):
        # search while the range is not empty
        while low <= high:
            mid = low + (high - low) // 2  # middle index
            if nums[mid] == target:
                # leftmost match: first in range, or the previous value is different
                if mid == low or nums[mid - 1] != nums[mid]:
                    return mid
                else:
                    high = mid - 1  # another copy exists on the left, keep looking there
            elif nums[mid] > target:
                high = mid - 1  # middle is too big, go left
            else:
                low = mid + 1  # middle is too small, go right
        return -1  # target not found