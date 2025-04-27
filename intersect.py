# Approach:
# - Always iterate over the smaller array for better space efficiency.
# - Use a Counter (hashmap) to count frequencies of elements in nums1.
# - For each element in nums2, if it exists in the counter, append it to the result and decrease the count.
#
# Time Complexity: O(m + n), where m and n are the lengths of nums1 and nums2.
# Space Complexity: O(min(m, n)), for storing the counts of the smaller array.

from collections import Counter

class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        if len(nums1) > len(nums2):
            nums1, nums2 = nums2, nums1
        
        count = Counter(nums1)
        res = []
        for num in nums2:
            if num in count:
                count[num] -= 1
                res.append(num)
                if not count[num]:
                    del count[num]
        
        return res
