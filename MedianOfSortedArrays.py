'''
    Time Complexity:
        O(log m) (where m = length of the smaller array)

    Space Complexity:
        O(1)

    Did this code successfully run on LeetCode?:
        Yes

    Problems faced while coding this:
        None

    Approach:
        Binary Search on Smaller Array.
        Divide the two arrays such that the elements in both of them are almost equal.
        If right of smaller array is >= left of bigger array and right of bigger array is >= left of smaller array:
            -> then your median will be calculated using these four number.

        If left of smaller array > left of bigger array:
            -> then Binary Search on the left side of the smaller array.

        Else:
            -> Binary Search on the right side of the smaller array.
'''

class Solution:
    def __init__(self):
        self.small = []
        self.big = []

    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        self.small, self.big = (nums1, nums2) if len(nums1) < len(nums2) else (nums2, nums1)

        return self.find_median(0, len(self.small))

    def find_median(self, start, end):
        if start > end:
            return 0

        part_small = (start + end) // 2
        part_big = self.part_big(part_small)

        min_small, max_small = self.get_min_max(self.small, part_small)
        min_big, max_big = self.get_min_max(self.big, part_big)

        if max_small <= min_big and max_big <= min_small:
            return self.median(min_small, max_small, min_big, max_big)

        elif max_small > max_big:
            return self.find_median(start, part_small - 1)

        return self.find_median(part_small + 1, end)

    def median(self, min_small, max_small, min_big, max_big):
        if (len(self.small) + len(self.big)) % 2 != 0:
            return max(max_small, max_big)
        return (max(max_small, max_big) + min(min_small, min_big)) / 2.0

    def part_big(self, part_small):
        return ((len(self.small) + len(self.big) + 1) // 2) - part_small

    def get_min_max(self, arr, part):
        return self.get_min(arr, part), self.get_max(arr, part)

    def get_min(self, arr, part):
        return arr[part] if part != len(arr) else float('inf')

    def get_max(self, arr, part):
        return arr[part - 1] if part != 0 else -float('inf')
