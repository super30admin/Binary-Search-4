# Time Complexity : O(m + n), where m and n are lengths of nums1 and nums2
# Space Complexity : O(min(m, n)) for the frequency map.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach : First we count the frequency of elements in the smaller array using a map.
# Then for each element in the larger array, we check if it exists in the map and collect it.
# We remove it from the map when its frequency becomes zero and finally return the result.

class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        n1, n2 = len(nums1), len(nums2)

        if n1 > n2:
            return self.intersect(nums2, nums1)

        freq_map = Counter(nums1)

        res = []

        for num in nums2:
            if num in freq_map:
                res.append(num)
                freq_map[num] -= 1
                if freq_map[num] == 0:
                    del freq_map[num]

        return res

        