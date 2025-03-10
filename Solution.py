'''
// Time Complexity :
# Problem 1 - O(m+n) ~ O(max(m,n)) -> Hashmap O(mlogm) -> 2 Pointers, m is longer array
            - O(m*log(n)) -> Binary search
# Problem 2 - O((m+n)*log(m)) m - is the shorter array
// Space Complexity :
# Problem 1 - O(m+n) Hashmap, O(1) - 2 Pointers, O(1) amortized - Binary search
# Problem 2 - O(1) amortized as we are not using any extra space
// Did this code successfully run on Leetcode :
# Yes the code ran successfully.

// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
'''
## Problem 1 - Intersection of Arrays II
# Hashmap Solution
# Find lengths of both the number arrays and make sure we have the lesser length array first.
# Iterate over the lesser array and append the Hashmap
# If the number in nums1 is present in nums2 we reduce the frwquency count and append result array.
# Return the result array.

class Solution(object):
    def intersect(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        if nums1 == None and nums2 == None and len(nums1) == 0 and len(nums2) == 0:
            return None 
        m = len(nums1)
        n = len(nums2)
        if m > n:
            self.intersect(nums2, nums1)
        map = {}
        for i in range(m):
            if nums1[i] in map:
                map[nums1[i]] += 1
            else:
                map[nums1[i]] = 1
 
        result = [] # Return list of numbers
        for j in range(n):
            if nums2[j] in map:
                result.append(nums2[j])
                map[nums2[j]] -= 1
                if map[nums2[j]] == 0:
                    del map[nums2[j]]
        return result

# Two pointers
# Find the lengths of both the arrays and make sure the array of lesser length is selected first
# Sort both the arrays, when the array element at the pointers is equal we append the result array.
# If the first array pointer value is less than second array pointer we increment first pointer else
# we increment the second pointer
# Iterate until both pointers cross each other and return the result array. 

class Solution(object):
    def intersect(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        if nums1 == None and nums2 == None and len(nums1) == 0 and len(nums2) == 0:
            return None 
        m = len(nums1)
        n = len(nums2)
        if m > n:
            self.intersect(nums2, nums1)
        
        nums1.sort()
        nums2.sort()
        result = []
        p1 = 0; p2 = 0
        while (p1 < m and p2 < n):
            if nums1[p1] == nums2[p2]:
                result.append(nums1[p1])
                p1 +=1; p2 += 1
            elif nums1[p1] < nums2[p2]:
                p1 += 1
            else:
                p2 += 1
        return result

# Binary Search
# Sort both the input arrays. Iterate over the smaller array and Binary search on the bigger array.
# Binary search - While low does not cross high find mid and if mid > target we move high to mid - 1
# else move low to mid + 1. If the target element is found then we check for bounds or if the element is
# not duplicated by looking for the earlier element and return index mid
# Using this index we append a temporary list with that element
# Finally append all elements of the temp list into result and return.

class Solution(object):
    def intersect(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        if nums1 == None and nums2 == None and len(nums1) == 0 and len(nums2) == 0:
            return None 
        m = len(nums1)
        n = len(nums2)
        nums1.sort()
        nums2.sort()         
        arr = []
        li = []
        low = 0; high = n-1
        for i in range(m):
            target = nums1[i]
            bsIdx = self.Binarysearch(nums2, low, high, target)
            if bsIdx != -1:
                li.append(target)
                low = bsIdx + 1

        result = []        
        for i in range(len(li)):
            result.append(li[i])
        return result
    
    def Binarysearch(self, li, low, high, target):
        while low <= high:
            mid = low + (high - low) / 2
            if li[mid] == target:
                if mid == low or li[mid] > li[mid-1]:
                    return mid
                else:
                    high = mid - 1
            elif li[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        return -1

## Problem 2 - Median of 2 sorted arrays
# Take lengths of both the arrays and change the order of the arrays with less elements to more elements
# Initialize low as '0' and high as length of smaller array. We perform Binary search until low & high 
# cross.
# Find partition X of nums 1 and partition Y of nums 2 such that the number of elements after partition 
# are the same.
# Check the bounds condition of change partition in case of edge cases as '-inf' or 'inf' else the 
# previous element or last element.
# Until the partition condition matches we find the mid as minimum of right partitions in case of odd
# size of arrays else the average of min of right and max of left partitions.
# Iterate over the binary search by changing low and high. Not found return '0.0'.

class Solution(object):
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        if nums1 == None and nums2 == None:
            return 0
        n1 = len(nums1)
        n2 = len(nums2)
        if n1 > n2:
            return self.findMedianSortedArrays(nums2, nums1)
        low = 0
        high = n1
        while low <= high:
            partX = low + (high - low) / 2
            partY = (n1 + n2) / 2 - partX
            if partX == 0:
                L1 = float('-inf')
            else:
                L1 = nums1[partX - 1]
            if partY == 0:
                L2 = float('-inf')
            else:
                L2 = nums2[partY - 1]
            if partX == n1:

                R1 = float('inf')
            else:
                R1 = nums1[partX]
            if partY == n2:
                R2 = float('inf')
            else:
                R2 = nums2[partY]
            if L1 <= R2 and L2 <= R1:
                ## correct partition
                if (n1 + n2)%2 == 0: # even size
                    return (min(R1, R2) + max(L1, L2)) / 2.0
                else: # odd size
                    return min(R1, R2) 
            elif L1 > R2:
                high = partX - 1
            else:
                low = partX + 1
        return 0.0