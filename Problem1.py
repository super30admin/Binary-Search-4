
class Solution:
    def intersect(self, nums1: list[int], nums2: list[int]) -> list[int]:

        nums1.sort()
        nums2.sort()

        x = 0
        y = 0
        res = []

        while x < len(nums1) and y < len(nums2):
            if nums1[x] == nums2[y]:
                res.append(nums1[x])
                x += 1
                y += 1
                continue

            if nums1[x] < nums2[y]:
                x += 1
            else:
                y += 1
        return res

