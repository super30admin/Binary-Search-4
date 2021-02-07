# -*- coding: utf-8 -*-
"""
TC:O(m+n) where m and n are the length of the two array sizes
SC:O(m+n) where m and n are the unique frequencies of elements presnt in both arrays
"""


#for this problem we use two dictioneries for two arrays
#we use the Counter sub-class of dictionary to count the no. of elemenst of two arrays
#we check for the length of the arrays, if nums1 is smaller, then we go through the dictionary1 items
#if same key in dict1 found in dict2, we put the frequency of the key in the output list
#if second list is smaller than first one, we repeat the same process 
from collections import Counter

class Solution:
    def intersect(self, nums1:[], nums2:[]):
        d1 = Counter(nums1)
        d2 = Counter(nums2)
        #output list
        l = []
        if len(nums1) <= len(nums2):
            for key,value in d1.items():
                if key in d2:
                    l.extend([key] * min(d2[key],value))
        else:
            for key,value in d2.items():
                if key in d1:
                    l.extend([key] * min(d1[key],value))
        return l
    
S = Solution()
print(S.intersect([4,9],[9,4,9,8,4]))