class Solution:
    def intersect(self, nums1, nums2):
        n1 = len(nums1)
        n2 = len(nums2)

        if n1 > n2:
            return self.intersect(nums2, nums1)

        result = []

        nums1.sort()
        nums2.sort()

        low = 0
        high = n2 - 1

        for num in nums1:
            bsIdx = self.binarySearch(nums2, num, low, high)
            if bsIdx != -1:
                result.append(num)
                low = bsIdx + 1

        re = [0] * len(result)
        for i in range(len(result)):
            re[i] = result[i]

        return re

    def binarySearch(self, nums, target, low, high):
        while low <= high:
            mid = low + (high - low) // 2
            if nums[mid] == target:
                if mid == low or nums[mid - 1] != nums[mid]:
                    return mid
                else:
                    high = mid - 1
            elif nums[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        return -1

# Time: O(m log m + n log n + m log n)
# Space: O(1)