"""
TC - O(m log m + n log n)
SC - O(1)
"""


class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        if nums1 is None or nums2 is None: return []

        n1 = len(nums1)
        n2 = len(nums2)

        # sort both the lists
        nums1.sort()
        nums2.sort()

        # create two pointers
        first = 0  # pointer for nums1
        second = 0  # pointer for nums2

        rtnData = []

        while first < n1 and second < n2:
            if nums1[first] == nums2[second]:
                rtnData.append(nums1[first])
                first += 1
                second += 1
            elif nums1[first] < nums2[second]:
                first += 1
            else:
                second += 1

        return rtnData