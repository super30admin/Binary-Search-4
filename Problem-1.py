from collections import defaultdict

"""
Approach: hash map

TC: O(n + m) ie O(n) | n -> len of larger list, len of smaller list
SC: O(m)
"""


class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        n1 = len(nums1)
        n2 = len(nums2)

        if n1 < n2:
            return self.intersect(nums2, nums1)

        result = []
        hash_map = defaultdict(int)
        for num in nums2:  # add all elements from smaller list
            hash_map[num] += 1

        for num in nums1:
            if num in hash_map:
                if hash_map[num] > 0:
                    hash_map[num] -= 1  # decrement count
                if hash_map[num] == 0:
                    hash_map.pop(num)
                result.append(num)  # add to result
        return result

    # approach 2: Two pointers
    """
    TC: O(n + m) if the arrays are sorted
    SC: O(1)
    """

    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        nums1.sort()
        nums2.sort()
        result = []
        i = 0
        j = 0
        while i < len(nums1) and j < len(nums2):
            # case 1: equal
            if nums1[i] == nums2[j]:
                result.append(nums1[i])
                i += 1
                j += 1
            elif nums1[i] > nums2[j]:
                j += 1
            else:
                i += 1
        return result

    """
    Approach 3: Binary seach
    1) iterate through the smaller list and at each element do a binary search on the larger list to find that element
    2) in case of duplicates example [2,2] [2,2,2]. Find the first occurence
        a) then exclude the found index in the next search space

    TC: O(n2 log n1) | n1 -> len(larger list)
    SC: O(1)

    """

    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        nums1.sort()
        nums2.sort()

        n1 = len(nums1)  # larger list
        n2 = len(nums2)

        if n1 < n2:
            return self.intersect(nums2, nums1)

        result = []
        low = 0
        high = n1 - 1  # for larger list
        for element in nums2:  # iterate through smaller
            found_index = self.modified_binary(low, high, element, nums1)
            if found_index != -1:
                low = found_index + 1  # if first occurrence found, exclude it from search space
                result.append(element)
        return result

    def modified_binary(self, low, high, target, nums):
        while (low <= high):
            mid = low + (high - low) // 2
            if nums[mid] == target:  # find the first occurrence in the duplicates
                if (mid == low or nums[mid] > nums[mid - 1]):  # first occurrence
                    return mid
                else:
                    high = mid - 1
            elif nums[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        return -1