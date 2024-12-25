# Binary-Search-4



## Problem1 
Intersection of Two Arrays II (https://leetcode.com/problems/intersection-of-two-arrays-ii/)
 Runtime: 23 ms, faster than 89.65% of Python online submissions for Intersection of Two Arrays II.
 Memory Usage: 11.4 MB, less than 87.45% of Python online submissions for Intersection of Two Arrays II.
class Solution(object):
    def intersect(self, nums1, nums2):
        # Sort both the arrays first...
        sortedArr1 = sorted(nums1)
        sortedArr2 = sorted(nums2)
        # Use two pointers i and j for the two arrays and initialize both with zero.
        i = 0
        j = 0
        # Create a output list to store the output...
        output = []
        while i < len(sortedArr1) and j < len(sortedArr2):
            # If sortedArr1[i] is less than sortedArr2[j]...
            # Leave the smaller element and go to next(greater) element in nums1...
            if sortedArr1[i] < sortedArr2[j]:
                i += 1
            # If sortedArr1[i] is greater than sortedArr2[j]...
            # Go to next(greater) element in nums2 array...
            elif sortedArr2[j] < sortedArr1[i]:
                j += 1
            # If both the elements intersected...
            # Add this element to output & increment both i and j.
            else:
                output.append(sortedArr1[i])
                i += 1
                j += 1
        return output       # Return the output array...




## Problem2
Median of Two Sorted Arrays (https://leetcode.com/problems/median-of-two-sorted-arrays)
class Solution:
    def findMedianSortedArrays(self, nums1, nums2):
        # Merge the arrays into a single sorted array.
        merged = nums1 + nums2

        # Sort the merged array.
        merged.sort()

        # Calculate the total number of elements in the merged array.
        total = len(merged)

        if total % 2 == 1:
            # If the total number of elements is odd, return the middle element as the median.
            return float(merged[total // 2])
        else:
            # If the total number of elements is even, calculate the average of the two middle elements as the median.
            middle1 = merged[total // 2 - 1]
            middle2 = merged[total // 2]
            return (float(middle1) + float(middle2)) / 2.0


