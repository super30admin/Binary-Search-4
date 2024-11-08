from collections import Counter


class Solution:
    def intersect(self, nums1, nums2):

        if len(nums1) > len(nums2):
            nums1, nums2 = nums2, nums1

        count_map = Counter(nums1)
        result = []

        for num in nums2:
            if count_map.get(num, 0) > 0:
                result.append(num)
                count_map[num] -= 1
                if count_map[num] == 0:
                    del count_map[num]

        return result


# time complexity is O(m+n)
# space complexity is O(m+min(m,n))
