'''
Time Complexity: O(max(nlogn, mlogm)) -> Which ever sorting is greater
Space Complexity: O(k) -> k is To save the result of the intersection
Did this code successfully run on Leetcode : Yes
Explanation: Use 2 pointer approach to find the intersection of the 2 arrays
'''

class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        left = 0
        right = 0
        result = []
        nums1 = sorted(nums1)
        nums2 = sorted(nums2)

        while left < len(nums1) and right < len(nums2):
            if nums1[left] == nums2[right]:
                result.append(nums1[left])
                left += 1
                right += 1
            elif nums1[left] >= nums2[right]:
                right += 1
            else:
                left += 1

        return result