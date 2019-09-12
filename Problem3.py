# Time Complexity : O(n+m log(n+m)) where n is number for elements in nums1 and m is number for elements in nums2
# Space Complexity :O(m+n)
# Did this code successfully run on Leetcode :Yes
# Any problem you faced while coding this : YES. I WAS NOT ABLE TO FIND AN OPTIMAL APPROACH...

class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        nums1.extend(nums2)
        nums1 = sorted(nums1)
        print(nums1)
        mid = (len(nums1) - 1) // 2
        if len(nums1) % 2 == 0:
            return (nums1[mid] + nums1[mid + 1]) / 2
        return nums1[mid]


# Here I have merged two lists and have soted them. Then I found the middle element and found the median and returned it.