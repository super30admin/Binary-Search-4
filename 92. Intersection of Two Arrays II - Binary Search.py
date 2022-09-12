class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        result = []

        if nums1 is None or len(nums1) == 0 or nums2 is None or len(nums2) == 0:
            return result
        nums1.sort()
        nums2.sort()
        if len(nums2) > len(nums1):
            return self.intersect(nums2, nums1)
        low = 0
        high = len(nums1) - 1

        for i in range(len(nums2)):
            mid = self.binarySearch(nums1, low, high, nums2[i])
            if mid != -1:
                result.append(nums2[i])
                low = mid + 1
        arr = []
        for i in result:
            arr.insert(i, i)

        return arr

    def binarySearch(self, nums1, low, high, target):
        while low <= high:
            mid = low + (high - low) // 2
            # print(mid, target, nums1, self.arr)
            if nums1[mid] == target:
                if mid == low or nums1[mid] > nums1[mid - 1]:
                    return mid
                else:
                    high = mid - 1  # keep moving left
            elif nums1[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        return -1

# two pointer Solution
# TC =O(mlogn).
# Space complexity : O(1).
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No
