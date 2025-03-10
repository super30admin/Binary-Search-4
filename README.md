# Binary-Search-4

## Problem1 
Intersection of Two Arrays II (https://leetcode.com/problems/intersection-of-two-arrays-ii/)

# Hashmap Solution
# Find lengths of both the number arrays and make sure we have the lesser length array first.
# Iterate over the lesser array and append the Hashmap
# If the number in nums1 is present in nums2 we reduce the frwquency count and append result array.
# Return the result array.

# Two pointers
# Find the lengths of both the arrays and make sure the array of lesser length is selected first
# Sort both the arrays, when the array element at the pointers is equal we append the result array.
# If the first array pointer value is less than second array pointer we increment first pointer else
# we increment the second pointer
# Iterate until both pointers cross each other and return the result array. 

# Binary Search
# Sort both the input arrays. Iterate over the smaller array and Binary search on the bigger array.
# Binary search - While low does not cross high find mid and if mid > target we move high to mid - 1
# else move low to mid + 1. If the target element is found then we check for bounds or if the element is
# not duplicated by looking for the earlier element and return index mid
# Using this index we append a temporary list with that element
# Finally append all elements of the temp list into result and return.

## Problem2
Median of Two Sorted Arrays (https://leetcode.com/problems/median-of-two-sorted-arrays)

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