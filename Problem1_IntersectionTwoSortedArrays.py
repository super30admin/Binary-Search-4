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
# O(N): Need to store hashmap of 1st array

#-----------------------
# Leet Code Performance: 
#-----------------------
# Ran Successfully?: Yes


# Two pointers
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
            nums1.sort()
            nums2.sort()
            n1 = len(nums1)
            n2 = len(nums2)
            
            p1 = 0
            p2 = 0
            
            result = []
            
            while p1 < n1 and p2 < n2:
                if nums1[p1] == nums2[p2]:
                    result.append(nums1[p1])
                    p1 += 1
                    p2 += 1
                elif nums1[p1] < nums2[p2]:
                    p1 += 1
                else:
                    p2 += 1

# Binary Search
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
            nums1.sort()
            nums2.sort()
            n1 = len(nums1)
            n2 = len(nums2)
            
            low = 0
            high = n2-1
            
            result = []

            
            for i in range(n1):
                curr = nums1[i]
                binSearchIndex = self.binarySearch(nums2, low, high, curr)
                if binSearchIndex != -1:
                    result.append(curr)
                    low = binSearchIndex + 1
            
            
            return result
        
    def binarySearch(self, arr, low, high, target):
        while low <= high:
            mid = low + (high - low)/2
            if arr[mid] == target:
                if mid == low or arr[mid] > arr[mid-1]:
                    return mid
                else:
                    high = mid - 1
            elif arr[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        return -1
