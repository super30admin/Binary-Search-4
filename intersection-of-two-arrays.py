'''
https://leetcode.com/problems/intersection-of-two-arrays-ii/

Did it run on leet code: Yes

Time Complexity: 0(max(n,m)) + 0(NlogN) + 0(MlogM)
Algorithm:
- sort the arrays
- Start from 0 indexes of both of your inputs
- if values at corresponding indexes is same then add to the result
- otherwise increment the pointers based on which has a greater value


'''


class Solution(object):
    def intersect(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        
        nums1.sort()
        nums2.sort()
        
        if len(nums1)>len(nums2):
            nums1,nums2 = nums2,nums1
       
        
        i,j=0,0
        
        result = []
        
        while i<len(nums1) and j<len(nums2):
            val1,val2 = nums1[i],nums2[j]
            
            if val1==val2:
                result.append(val1)
                i+=1
                j+=1
            
            elif val1>val2:
                j+=1
            else:
                i+=1
        return result
        
