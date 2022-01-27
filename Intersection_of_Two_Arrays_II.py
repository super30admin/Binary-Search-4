class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        """
        Time complexity : nlogn + mlogm
        Space complexity : o(1)
        """
        nums1.sort()
        nums2.sort()
        one = 0
        two = 0
        final = []
        while one < len(nums1) and two < len(nums2):
            if nums1[one] == nums2[two]:
                final.append(nums1[one])
                one += 1
                two += 1
            elif nums1[one] > nums2[two]:
                two += 1
            else:
                one += 1
        return final