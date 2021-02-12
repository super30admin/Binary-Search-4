# Created by Aashish Adhikari at 7:29 PM 2/5/2021

'''
Time Complexity:
O(max(m,n))

Space Complexity:
O(min(m,n)) as we store the smaller array in the hashmap.
'''


class Solution(object):
    def intersect(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """

        if len(nums1) == 0 or len(nums2) == 0:
            return []


        n1 = len(nums1)
        n2 = len(nums2)

        if n1 > n2:
            return (self.intersect(nums2, nums1))
        hm = {}

        # add nums1 to hashmap
        for idx in range(0, len(nums1)):
            if nums1[idx] in hm:
                hm[nums1[idx]] += 1
            else:
                hm[nums1[idx]] = 1

        result = []

        for idx in range(0, len(nums2)):
            if nums2[idx] in hm:

                if hm[nums2[idx]] > 0:
                    result.append(nums2[idx])

                    hm[nums2[idx]] -= 1

        return result



