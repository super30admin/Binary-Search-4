#Time Complexity: O(nlogn)
#Space Complexity: O(1)
#Did it run on leetcode: yes

class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        nums1 = nums1 + nums2
        nums1 = sorted(nums1)
        n = len(nums1)
        if n % 2 == 0:
            return (nums1[n//2 - 1] + nums1[(n//2)])/2 
        else:
            n = math.ceil(n/2)
            return nums1[n-1]