from collections import defaultdict, Counter
from typing import List


class Solution:
    def intersectHashMap(self, nums1: List[int], nums2: List[int]) -> List[int]:
        """
            https://leetcode.com/problems/intersection-of-two-arrays-ii/
            Time Complexity - O(m+n)
                'm' is the length of nums1,
                'n' is the length of nums2
            Space Complexity - O(n)
                'n' is the smaller of the two lists.
        """
        # take min of both the lists to reduce space
        if len(nums2) < len(nums1):
            nums1, nums2 = nums2, nums1

        count = Counter(nums1)
        output = []
        for i in range(len(nums2)):
            if count[nums2[i]] > 0:
                count[nums2[i]] -= 1
                output.append(nums2[i])
        return output

    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        """
            https://leetcode.com/problems/intersection-of-two-arrays-ii/
            Time Complexity - O(nlogn)
                'n' is the length of the larger list
            Space Complexity - O(n)
        """
        # sort both the lists
        nums1, nums2 = sorted(nums1), sorted(nums2)
        output = []
        ptr1 = ptr2 = 0
        while ptr1 < len(nums1) and ptr2 < len(nums2):
            # if we found a intersection, move both the pointers
            if nums1[ptr1] == nums2[ptr2]:
                output.append(nums1[ptr1])
                ptr1 += 1
                ptr2 += 1
            # move the pointer with smaller value
            # because the larger value can be present as we move forward
            elif nums1[ptr1] < nums2[ptr2]:
                ptr1 += 1
            else:
                ptr2 += 1
        return output


if __name__ == '__main__':
    print(Solution().intersectHashMap([9, 4, 9, 8, 4], [4, 9, 5]))
    print(Solution().intersect([9, 4, 9, 8, 4], [4, 9, 5]))
