# time complexity : O(n)
# space complexity : O(1)
# runs on leetcode : YES
# any problem faced : No
import math
class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        for i in nums2:
            nums1.append(i)
        nums1.sort()
        length = len(nums1)
        if length % 2 == 0:
            length1 = length/2
            a = math.floor(length1)
            ans = ( nums1[a-1] + nums1[a] ) / 2
            return round(ans, 5)
        else:
            index = length // 2
            ans = round(nums1[index], 5)
            return ans
            
        