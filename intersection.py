# Time complexity: O(n + m)
# Space complexity: O(min(n, m))

from collections import Counter

def intersect(nums1, nums2):
    count1, count2 = Counter(nums1), Counter(nums2)
    return list((count1 & count2).elements())
