# Time Complexity : O(n + m), where n is the length of nums1 and m is the length of nums2
# Space Complexity : O(min(n, m)), since I store the frequency of the smaller array
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# I used a hashmap (Counter) to store frequencies of elements in nums1.
# Then I looped through nums2, and for each element, if it was still in the hashmap with a positive count,
# I added it to the result and decreased the count.

from collections import Counter
from typing import List

class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        count = Counter(nums1)
        result = []

        for num in nums2:
            if count[num] > 0:
                result.append(num)
                count[num] -= 1

        return result
