''' Accepted on leetcode(4)
time - O(m+n*log(m+n)), space - O(m+n)
Brute force approach - joined 2 arrays and sort them and then find the median.
'''
class Solution:
    def findMedianSortedArrays(self, nums1, nums2) -> float:
        nums1.extend(nums2)
        nums = sorted(nums1)
        # print(nums)
        n = len(nums)
        if n % 2 == 0:
            return  (nums[n//2] + nums[n//2 -1]) / 2
        else:
            return nums[n//2]
        return -1