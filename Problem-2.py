#  4. Median of Two Sorted Arrays
'''
Leetcode all test cases passed: Yes
class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
      n is length of nums1
      m is length of nums2
      Time Complexity: O(log(min(m,n)))
      Space Complexity: O(1)
'''
class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        if len(nums1) == 0 and len(nums2) == 0:
            return 0
        if len(nums2) < len(nums1):
            return self.findMedianSortedArrays(nums2,nums1)
        l =0 
        r = len(nums1)
        while l <=r :
            partX = (l + r) // 2
            partY = ((len(nums1) + len(nums2)) // 2) - partX
            l1 = float("-inf") if partX == 0 else nums1[partX - 1]
            r1 = float("inf") if partX == len(nums1) else nums1[partX]
            l2 = float("-inf") if partY == 0 else nums2[partY - 1]
            r2 = float("inf") if partY == len(nums2) else nums2[partY]
            if l1 <= r2 and l2 <= r1:
                #Partition Match
                if (len(nums1) + len(nums2) )% 2 == 0:
                    return (min(r1,r2) + max(l1,l2)) / 2 
                else:
                    return min(r1,r2)
            else:
                if l2 > r1:
                    l = partX + 1
                else:
                    r = partX - 1
