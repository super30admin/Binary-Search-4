'''
// Time Complexity : O(log(min(m,n)))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english : same implementation as in class

// Your code here along with comments explaining your approach
'''
class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        m, n = len(nums1), len(nums2)

        if m > n:
            return self.findMedianSortedArrays(nums2, nums1)
        
        l, h = 0, m

        while l <= h:
            partm = l + (h - l) // 2
            partn = (n + m + 1) // 2 - partm

            l1 = nums1[partm - 1] if partm != 0 else float("-inf")
            l2 = nums2[partn - 1] if partn != 0 else float("-inf")
            h1 = nums1[partm] if partm != m else float("inf")
            h2 = nums2[partn] if partn != n else float("inf")
            if l1 <= h2 and l2 <= h1:
                # found right partition
                if (m + n) % 2 == 0:
                    return (max(l1, l2) + min(h1, h2)) / 2
                else:
                    return max(l1, l2)
            elif l1 > h2:
                h = partm - 1
            else:
                l = partm + 1
        return -1