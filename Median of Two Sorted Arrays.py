#  Time Complexity :  O(log(min(m, n))) — binary search on smaller array
#  Space Complexity : O(1)
#  Did this code successfully run on Leetcode : Yes
#  Three line explanation of solution in plain english : This code finds the median of two sorted arrays using binary search on the smaller array to achieve O(log(min(m, n))) time. It partitions both arrays (part1 in nums1 and part2 in nums2) so that the left side contains half of the elements, ensuring all left-side elements are ≤ right-side elements. Once a valid partition is found, it returns either the max of the left partition (odd length) or the average of the max of the left and min of the right (even length)


class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        if len(nums1) > len(nums2):
            nums1, nums2 = nums2, nums1
        
        m = len(nums1)
        n = len(nums2)
        
        l = 0
        r = m

        while l <= r:
            part1 = (l + r) // 2
            part2 =  (m + n + 1) // 2 - part1

            l1 = float('-inf') if part1 == 0 else nums1[part1 - 1]
            r1 = float('inf') if part1 == m else nums1[part1]

            l2 = float('-inf') if part2 == 0 else nums2[part2 - 1]
            r2 = float('inf') if part2 == n else nums2[part2]

            if l1 <= r2 and l2 <= r1:
                if (m + n) % 2 == 1:
                    return max(l1, l2)      
                return (max(l1, l2) + min(r1, r2)) / 2
            elif l1 > r2:
                r = part1 - 1   
            else:
                l = part1 + 1