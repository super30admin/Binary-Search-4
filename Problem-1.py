#  350. Intersection of Two Arrays II
'''
Leetcode all test cases passed: Yes
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
      n is length of nums1
      m is length of nums2
      Time Complexity: O(m + n)
      Space Complexity: O(min(m , n))
'''
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        a = {}
        
        res =[]
        
        if len(nums1) <= len(nums2):
            for i in nums1:
                if i not in a:
                    a[i] = 0
                a[i] += 1
            for i in nums2:
                if i in a and a[i] > 0:
                    res.append(i)
                    a[i] -= 1
        else:
            for i in nums2:
                if i not in a:
                    a[i] = 0
                a[i] += 1
            for i in nums1:
                if i in a and a[i] > 0:
                    res.append(i)
                    a[i] -= 1
        return res
