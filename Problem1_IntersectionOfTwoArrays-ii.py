# Time Complexity: O(m logn), where m - length of nums1 and n - length of nums2
# Space Complexity: O(1)

# Solution:

class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        if not nums1 or not nums2:
            return []

        n1 = len(nums1)
        n2 = len(nums2)

        # Consider smaller array as nums1
        if n2 < n1:
            return self.intersect(nums2, nums1)

        nums1.sort()
        nums2.sort()
        result = []
        low = 0

        # For every value in nums1, search for its match in nums2
        for i in range(n1):
            index = self.binary_search(nums2, nums1[i], low)

            # If match is found, add to result and continue the search for other values in the right half of the index
            if index != -1:
                result.append(nums1[i])
                low = index + 1

        return result

    # Returns the lowest index of the match
    def binary_search(self, nums: List[int], x: int, low: int) -> int:
        high = len(nums) - 1
        while low <= high:
            mid = low + (high - low) // 2
            if nums[mid] == x:
                if mid == low or nums[mid - 1] < nums[mid]:
                    return mid
                else:
                    high -= 1
            elif x > nums[mid]:
                low = mid + 1
            else:
                high = mid - 1

        return -1










