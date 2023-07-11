'''
Problem: Intersection of Two Arrays II
Time Complexity: O(nlogn + mlogm), where n and m is given elements in 2 arrays
Space Complexity: O(1)
Did this code successfully run on Leetcode: Yes
Any problem you faced while coding this: No
Your code here along with comments explaining your approach:
        sort both array
        increament i and j on both arrays resp
        if element is same then add it in result
'''

class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        n1 = len(nums1)
        n2 = len(nums2)
        nums1.sort()
        nums2.sort()
        i = 0
        j = 0

        result = []

        while i <n1 and j < n2:
            if nums1[i]<nums2[j]:
                i+=1
            elif nums1[i]>nums2[j]:
                j+=1
            else:
                result.append(nums1[i])
                i+=1
                j+=1
        
        return result

            
