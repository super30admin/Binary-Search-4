# Time Complexity : O(m) + O(n)
# Space Complexity:o(n)
#  Did this code successfully run on Leetcode : Yes
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        if nums1 is None or nums2 is None or len(nums1) == 0 or len(nums2) == 0:
            return []

        hashMap = {}

        result = []

        if len(nums1) < len(nums2):
            self.intersect(nums2, nums1)

        for num in nums2:
            hashMap[num] = hashMap.get(num, 0) + 1

        for num in nums1:
            if num in hashMap and hashMap.get(num) != 0:
                result.append(num)
                hashMap[num] = hashMap.get(num) - 1

        return result


#Solution 2:
# Time Complexity : O(mlogm) + O(nlogn) + O(nlogm)
# Space Complexity:o(1)
# Did this code successfully run on Leetcode : Yes

class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        if nums1 is None or nums2 is None or len(nums1) == 0 or len(nums2) == 0:
            return []

        result = []

        if len(nums1) < len(nums2):
            self.intersect(nums2, nums1)

        nums1.sort()
        nums2.sort()

        # Binary search if both array are sorted.

        low = 0
        high = len(nums1) - 1

        for num in nums2:
            index = self.binarySearch(num, low, high, nums1)
            if index != -1:
                result.append(num)
                low = index + 1

        return result

    def binarySearch(self, num, low, high, num1):

        while low <= high:
            mid = int(low + (high - low) / 2)

            if num1[mid] == num:
                if mid == low or num1[mid - 1] < num1[mid]:
                    return mid
                else:
                    high = mid - 1

            elif num1[mid] > num:
                high = mid - 1
            else:
                low = mid + 1

        return -1




