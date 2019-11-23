class Solution(object):
    def intersect(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        d1 = {}

        result = []
        for num in nums1:
            if num not in d1:
                d1[num] = 1
            else:
                d1[num] += 1

        for n in nums2:
            if n in d1.keys() and d1[n] != 0:
                result.append(n)
                d1[n] -= 1
        return result