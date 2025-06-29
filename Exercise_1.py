# S30 Problem #91 Intersection of Two Arrays II
#LeetCode #350  https://leetcode.com/problems/intersection-of-two-arrays-ii/description/

# Author : Akaash Trivedi
# 2 pointers: O(n1 + n2)
## For sorting O(n1 log n1 + n2 log n2)
## Time Complexity : O(n1 log n1 + n2 log n2)
## Space Complexity : O(1)
# Binary search
## Time Complexity : (n2 log n1) n2 -> smaller array, n1 -> larger
## Space Complexity : O(1)
# Did this code successfully run on Leetcode :  Yes #
# Any problem you faced while coding this : No

# two pointer solution
# sort the arrays
# pointer on each array and check it index are equal, if not increase the smaller element to next
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        nums1.sort()
        nums2.sort()
        i, j = 0, 0
        res =[]
        while i < len(nums1) and j < len(nums2):
            if nums1[i] == nums2[j]:
                res.append(nums1[i])
                i += 1
                j += 1
            elif nums1[i] < nums2[j]:
                i += 1
            elif nums1[i] > nums2[j]:
                j +=1
        return res 
    
# binary search solution
# sort the arrays
# do linear operation on smaller array O(m)
# Binary search on larger array O(log n)
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        n1 = len(nums1)
        n2 = len(nums2)
        if n1 < n2:
            self.intersect(nums2, nums1)
        nums1.sort()
        nums2.sort()
        # Binary on larger array: nums1
        low, high = 0, n1-1
        res = []
        for i in range(n2):
            bsIndex = self.binarySearch(nums1, low, high, nums2[i])
            if bsIndex != -1:
                res.append(nums2[i])
                # oving the low so dont repeat and find same element and reduce the search space
                low = bsIndex + 1
        return res 
        
    def binarySearch(self, arr, low, high, target):
        while low <= high:
            # avoid integer iverflow
            mid = low + (high -low) //2
            if arr[mid] == target:
                # find the first occurance of the element, if elements are repeated
                if mid == low or arr[mid] > arr[mid-1]:
                    return mid
                else:
                    high = mid -1
                #self.res.append(arr[mid])
            elif arr[mid] > target:
                high = mid - 1
            else:
                low = mid +1
        return -1