class Solution:
    def intersect(self, nums1, nums2):
        nums1 = sorted(nums1)
        nums2 = sorted(nums2)

        res = []
        p1 = 0
        p2 = 0
        while p1 < len(nums1) and p2 < len(nums2):
            if nums1[p1] == nums2[p2]:
                res.append(nums1[p1])
                p1 += 1
                p2 += 1
                
            elif nums1[p1] < nums2[p2]:
                p1 += 1
            else:
                p2 += 1
        return res
#TC: O(n log(n)) + O(m log(m))
#SC: O(1)