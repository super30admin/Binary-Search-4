# Problem 1 : Intersection of Two Arrays II
# Time Complexity : 
'''
Two Pointers - O(m+n) where m, n are size of two list and m > n
Binary Search - O(mlogn) where m and n are the size of two list
'''
# Space Complexity : 
'''
Two Pointers - O(1)
Binary Search - O(1)
''' 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
'''
None
'''

# Your code here along with comments explaining your approach
# Two pointer solution
from typing import List
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        # initializing the result variable to store the result
        result = []
        # checking if the length of the nums1 and nums2 is zero then return empty []
        if (len(nums1) == 0 and len(nums2) == 0): return result
        # set the two index to zero; one index for each list
        first = 0
        second = 0
        # sort the array
        nums1.sort()
        nums2.sort()
        # loop until both the index are less than the length of the respective list
        while(first < len(nums1) and second < len(nums2)):
            # if the number pointed by index are equal then add to result and increment the pointers
            if(nums1[first] == nums2[second]):
                result.append(nums1[first])
                first += 1
                second += 1
            # if the element of first list is greather than second list then increment the second pointer
            elif (nums1[first] > nums2[second]):
                second += 1
            # else increment the first pointer
            else:
                first += 1
        
        return result



# Binary Soltuion
from typing import List
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        # checking if the length of the both arrays is zero then return empty []
        if (len(nums1) == 0 or len(nums2) == 0): return []
        # sort both the arrays using sort function
        nums1.sort()
        nums2.sort()
        # result varaible to store the list of intersected elements
        result = []
        # index variable to store index for second array
        index = 0

        # binary search function to find the element target in nums2 array
        def binarySearch(nums2: List[int], index: int, target: int) -> int:
            # setting low and high variable
            low = index
            high = len(nums2) -1
            # loop till low <= high
            while(low <= high):
                # find middle element
                mid = low +(high-low) // 2
                # if the nums[mid] element is less than target then set low to mid+1
                if(nums2[mid] < target):
                    low = mid + 1
                # elseset high to mid-1
                else:
                    high = mid - 1
            # return low variable which stores index of the find element or if not found then return last value of low
            return low

        # loop through nums1 array
        for i in range(len(nums1)):
            # find the index of nums[i] element in nums2 if it is present
            loc = binarySearch(nums2, index, nums1[i])
            # after getting the index check if the it is less than length of nums2 and both elements are equal
            if (loc < len(nums2) and nums2[loc] == nums1[i]):
                # this means we found the intersection element so add to result
                result.append(nums1[i])
                # to avoid using the same element we adjust the index of nums2 to loc+1 ie setting the low to avoid the case.
                index = loc+1
        return result     

