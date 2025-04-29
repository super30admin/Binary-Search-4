# Time Complexity : O(m+n)
# Space Complexity : O(min(m,n))
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach:
# 1. Use a hashmap to store the count of each element in the in the larger array.
# 2. Iterate through the smaller array and check if the element is present in the hashmap.
# 3. If present, append it to the result and decrement the count in the hashmap.
# 4. If the count becomes zero, remove the element from the hashmap.
# 5. Return the result.
import collections
class Solution:
    def intersect(self, nums1, nums2):
        # Get the length of both arrays
        m, n = len(nums1), len(nums2)
        # Flag to keep track of which array is larger
        flag = False
        # If nums1 is larger than nums2, set flag to True
        if m > n:
            flag = True
            # Store the count of each element in nums1
            countMap = collections.Counter(nums1)
        else:
            # If nums2 is larger, store the count of each element in nums2
            countMap = collections.Counter(nums2)

        # Function to get the intersection of the two arrays
        def getIntersection(nums):
            # Initialize an empty result list
            res = []
            # Iterate through the smaller array
            for n in nums:
                # If the element is present in the countMap
                if n in countMap:
                    # Append the element to the result list
                    res.append(n)
                    # Decrement the count in the countMap
                    countMap[n] -= 1
                    # If the count becomes zero, remove the element from the countMap
                    if countMap[n] == 0:
                        del countMap[n]
            # Return the result list
            return res
        # Call the getIntersection function with the smaller array
        # and return the result based on the flag
        if flag:
            return getIntersection(nums2)
        else:
            return getIntersection(nums1)

# Time Complexity : O(mlogm + nlogn)
# Space Complexity : O(1)
# Approach:
# 
# 1. Sort both arrays.
# 2. Use two pointers to traverse both arrays.
# 3. If the elements at both pointers are equal, add it to the result and move both pointers.
# 4. Otherwise, move the pointer of the array with the larger element.
# 5. Continue until one of the pointers reaches the end of its array.
# 6. Return the result. 
class Solution:
    def intersect(self, nums1, nums2):
        # Sort both arrays
        nums1.sort()
        nums2.sort()
        # Initialize two pointers for both arrays
        n1, n2 = len(nums1)-1, len(nums2)-1
        # Initialize an empty result list
        res = []
        # Traverse both arrays until one of the pointers reaches the end of its array
        while n1>=0 and n2>=0:
            # If the elements at both pointers are equal
            if nums1[n1] == nums2[n2]:
                # Add it to the result
                res.append(nums1[n1])
                # Move both pointers
                n1 -= 1
                n2 -= 1
            # If the element in nums1 is greater, move the pointer of nums1
            elif nums1[n1] > nums2[n2]:
                n1 -= 1
            # If the element in nums2 is greater, move the pointer of nums2
            else:
                n2 -= 1
        # Return the result
        return res
    
# Time Complexity : O(mlogn) 
# Space Complexity : O(1)
# Approach:
# 1. Sort both arrays.
# 2. For each element in the smaller array, perform a binary search in the larger array to find the index of the element.
# 3. If found, append it to the result and update the search range for the next element.
# 4. Continue until all elements in the smaller array are processed.
# 5. Return the result.
# Note: This approach is not optimal for large arrays as it has a time complexity of O(mlogn) and space complexity of O(1).
class Solution:
    def intersect(self, nums1, nums2):
        # Make sure to always iterate through the smaller array
        # to minimize the number of iterations
        if len(nums1) > len(nums2):
            return self.intersect(nums2, nums1)
        # Get the length of both arrays
        n1, n2 = len(nums1), len(nums2)
        # Sort both arrays
        nums1.sort()
        nums2.sort()
        # Initialize an empty result list
        res = []
        
        # Function to perform binary search to find index of the first occurrence of an element in the larger array
        def binarySearch(n, l, h):
            # Iterate until the search range is valid
            while l <= h:
                # Calculate the mid index
                mid = l + (h-l)//2
                # If the element is found at mid index
                if nums2[mid] == n:
                    # Check if it is the first occurrence
                    if mid == l or nums2[mid] != nums2[mid-1]:
                        # If it is, return the index
                        return mid
                    # Otherwise, continue searching in the left half
                    else:
                        h = mid - 1
                # If the element is less than n, search in the right half
                elif nums2[mid] < n:
                    l = mid + 1
                # If the element is greater than n, search in the left half
                else:
                    h = mid - 1
            # If the element is not found, return -1
            return -1
        # Initialize the search range
        low, high = 0, n2-1
        # Iterate through the smaller array
        # and perform binary search in the larger array
        for n in nums1:
            # Perform binary search to find the index of the element
            idx = binarySearch(n, low, high)
            # If the element is found
            if idx != -1:
                # Append it to the result
                res.append(n)
                # Update the search range for the next element
                low = idx+1
        # Return the result
        return res