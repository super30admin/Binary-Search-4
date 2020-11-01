# Leetcode: https://leetcode.com/problems/intersection-of-two-arrays-ii/

# Approach 1: Basic (not implemented): Bruteforce, iterate over two arrays using two for loops, Time Complexity: O(m*n)
# Approach 2. Using hashmap (implemented):
#     Time Complexity: O(min(m,n)) for traversing the array, look up in hashmap is O(1)
#     Space Complexity: O(min(m,n)) as we'll store the values of min len array in hashmap

# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        # always store smaller array in hashmap to save space
        if len(nums2) < len(nums1):
            self.intersect(nums2, nums1)

        result = []
        hmap = {}

        for num in nums1:
            if num in hmap:
                hmap[num] += 1
            else:
                hmap[num] = 1

        for num in nums2:
            if num in hmap and hmap[num] > 0:
                result.append(num)
                hmap[num] -= 1

        return result


# Approach 3: Using Two pointers
# Time Complexity: O(log n), where n is the length of larger array
# Space Complexity: O(n) to store the result array, O(1) if not considering result array


class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        nums1.sort()
        nums2.sort()
        result = []

        ptr1 = 0
        ptr2 = 0

        while ptr1 < len(nums1) and ptr2 < len(nums2):
            if nums1[ptr1] == nums2[ptr2]:
                result.append(nums1[ptr1])
                ptr1 += 1
                ptr2 += 1
            elif nums1[ptr1] < nums2[ptr2]:
                ptr1 += 1
            else:
                ptr2 += 1

        return result


# Approach 4: Using Binary search. Iterate over a smaller array and binary search each element in bigger array
# Time Complexity: O(m log n) where m is the length of smaller array and n is the length of bigger array
# Space Complexity: O(m) to store the result array, O(1) if not considering result array


class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        # use binary search on a bigger array
        if len(nums2) < len(nums1):
            self.intersect(nums2, nums1)

        result = []
        # base case
        if len(nums1) is 0 or len(nums2) is 0:
            return result

        # Sort both the array to apply binary search
        nums1.sort()
        nums2.sort()

        for num in nums1:
            if self.binary_search(nums2, num) == True:
                result.append(num)

        return result

    def binary_search(self, nums, target):
        left = 0
        right = len(nums) - 1

        while left <= right:
            mid = left + (right - left) // 2
            if nums[mid] == target:
                nums.pop(mid)
                return True
            elif nums[mid] < target:
                left = mid + 1
            elif nums[mid] > target:
                right = mid - 1
        return False


