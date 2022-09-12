class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        result = []

        if nums1 is None or len(nums1) == 0 or nums2 is None or len(nums2) == 0:
            return result
        nums1.sort()
        nums2.sort()
        if len(nums2) > len(nums1):
            return self.intersect(nums2, nums1)
        p1 = 0
        p2 = 0

        while p1 < len(nums1) and p2 < len(nums2):
            if nums1[p1] == nums2[p2]:
                result.append(nums1[p1])
                p1 += 1
                p2 += 1
            elif nums1[p1] < nums2[p2]:
                p1 += 1
            else:
                p2 += 1

        arr = []
        for i in result:
            arr.insert(i, i)

        return arr


# two pointer Solution
# TC =O(m+n)
# Space complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No
