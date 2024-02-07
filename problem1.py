#Time Complexity :  O(n1 * log(n1) + n2 * log(n2))
#Space Complexity :O(min(n1, n2))
#Did this code successfully run on Leetcode : yes

from ast import List


class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        n1 = len(nums1)
        n2 = len(nums2)
        nums1.sort()
        nums2.sort()
        if n1 == 0 or n2 == 0:
            return []

        if n1 > n2:
            return self.intersect(nums2, nums1)

        p1 = 0
        p2 = 0
        li = []
        while p1 < n1 and p2 < n2:
            if nums1[p1] == nums2[p2]:
                li.append(nums1[p1])
                p1 += 1
                p2 += 1
            else:
                if nums1[p1] < nums2[p2]:
                    p1 += 1
                else:
                    p2 += 1
            
        return li