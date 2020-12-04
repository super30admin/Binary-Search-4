'''
Accepted on leetcode(350)
Time - O(logn)
'''


class Solution:
    def intersect(self, nums1, nums2):
        nums1 = sorted(nums1)
        nums2 = sorted(nums2)
        # Declaring variables
        result = []
        p1 = 0
        p2 = 0

        # Iterate over the arrays and check the 3 conditions
        while p1 < len(nums1) and p2 < len(nums2):
            val1 = nums1[p1]
            val2 = nums2[p2]
            # case1: Both values are equal
            if val1 == val2:
                result.append(val1)
                p1 += 1
                p2 += 1
            # case 2: val1 is less than val 2
            elif val1 < val2:
                p1 += 1
            # case 3: val1 is greater than val2
            else:
                p2 += 1
        # result result array
        return result