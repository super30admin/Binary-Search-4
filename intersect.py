# Time Complexity : O(nlogm) where n is size of nums1, m is size of nums2
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        def bs(low, high, key):

            while low <= high:
                mid = (low + high) // 2

                if nums2[mid] == key:
                    return True

                elif nums2[mid] > key:
                    high = mid - 1

                else:
                    low = mid + 1

            return False

        nums2.sort()

        out = []

        for i in nums1:
            if bs(0, len(nums2) - 1, i):
                out.append(i)
                nums2.remove(i)
        return out
