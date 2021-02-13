# TC: O(N)
# SC: O(N)

# Yes, it ran on leetcode
# Not able to do in binary search

import collections
class Solution:
    def intersect(self, nums1, nums2):
        counts = collections.Counter(nums1)
        print(counts)
        ans = []
        for i in nums2:
            if counts[i]>0:
                ans.append(i)
                counts[i] -= 1
        return ans