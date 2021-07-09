'''
====== Submission Details =======
Student Name: Pavan Kumar K. N.
S30 SlackID : RN32MAY2021
=================================
'''

# 350. Intersection of Two Arrays II


# https://leetcode.com/problems/intersection-of-two-arrays-ii/
#-----------------
# Time Complexity: 
#-----------------
# O(M+N) - Need to iterate over both array once

#------------------
# Space Complexity: 
#------------------
# O(N): Need to store hashmap of the shorter array

#-----------------------
# Leet Code Performance: 
#-----------------------
# Ran Successfully?: Yes

class Solution(object):
    def intersect(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        if len(nums1) > len(nums2):
            return self.intersect(nums2, nums1)
        
        else:
        
            result = []
            map1 = {}
            for x in nums1:
                if x in map1:
                    map1[x] += 1
                else:
                    map1[x] = 1
            for y in nums2:
                if y in map1:
                    map1[y] -= 1
                    result.append(y)
                    if map1[y] == 0:
                        del map1[y]

            return result
