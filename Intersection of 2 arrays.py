#// Time Complexity : O(n log m) 
# // Space Complexity : O(1) 
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : no because i saw the class video and then did the problem.

class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        
        def binary(low,high,arr,target):
            while low <= high:
                mid = (low + high) //2
                if arr[mid] == target:
                    if mid == low or arr[mid] != arr[mid -1]:
                        return mid
                    else:
                        high = high -1
                elif arr[mid] > target:
                    high = mid - 1
                else:
                    low = mid + 1
            return -1
        
        if len(nums1) > len(nums2):
            return self.intersect(nums2,nums1)
        nums1.sort()
        nums2.sort()
        result = []
        low = 0
        high = len(nums2) - 1
        for i in range(len(nums1)):
            bind = binary(low,high,nums2,nums1[i])
            if bind != -1:
                result.append(nums2[bind])
                low = bind + 1
        return result

# Approach:
# The problem can be solved using a binary search approach. The idea is to sort both the arrays and
# then perform a binary search on the second array for each element in the first array. If the element
# is found, it is added to the result list and the search space is reduced for the next element

    
        