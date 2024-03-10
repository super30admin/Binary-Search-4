# https://leetcode.com/problems/median-of-two-sorted-arrays/

# Time Complexity : O(log (min (M, N)) where M, N are lengths of the input arrays.
# Space Complexity : O(1) is length of the input string
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Yes.


# Your code here along with comments explaining your approach

# Approach : We virtually divide both the arrays. One way is to divide the first array in the center.
# Assume arrays are [1, 3, 5, 7, 9, 11] and [2, 4, 6, 8, 10, 12]
# Now we have 2 parts of this array, let's say first_left of array has 3 elements, and first_right of
# the array has 3 elements. elements of are [1, 3, 5] and [7, 9, 11]
# Now we have to divide the second half in a way such that total elements on the first_left and second_left are
# equal to first_right and second_right. So the formula is (len1  + len2) // 2 - len(partitionA)
# we get partitionB = (6 + 6) // 2 - 3 = 3. So virtually second_left = [2, 4, 6] and second_right = [8, 10, 12]
# Now, first_left and second_left = [1, 2, 3, 4, 5, 6] and first_right and second_right = [7, 8, 9, 10, 11, 12]
# We can figure out if all elements of left are sorted and less than equal to all elements on right by two conditions.
# [1, 3, 5] - should be compared with [8, 10, 12] here if 5 is less than 8 we know it is sorted.
# [2, 4, 6] - should be compared with [7, 9, 11] here if 6 is less than 7 we know it is sorted.
# If we can partition it at the right point, we can calculate median and return the result.
# Let's take few more examples.
# [1, 10, 12, 14] and [3, 5, 7, 9]
# first level partition
# [1, 10]   |   [12, 14]
# [3, 5]    |   [7, 9]
# compare 10 with 7 and 5 with 12. So one condition is failing. 10 should be lesser than 7. So we have to move our high
# to one position left.
# Second level partition
# [1]           |   [10, 12, 14]
# [3, 5, 7]     |   [9]
#  Compare 1 with 9 and 7 with 10. We found the correct partition.
#  If we sorted the arrays the median will be max of left + min on right divided by 2 as total number of elements in
#  both the arrays is even
# Example 3
# [1, 19, 23] [25, 29]
# first level partition
# [1]     |   [19, 23]
# [25]    |   [29]
# Compare 1 with 29 and 25 with 19 one condition fails. as 25 is less than 19, we move out low to one position right
# [1, 19]   |   [23]
# []        |   [25, 29]
# Empty array is consider as -inf if it is on left and +inf if it is on right.
# now compare 19 < 25 and -inf < 23. So, we found the right partition. number of elements on the right will be one
# element extra. So we return the minimum element on the right.


from typing import List


class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        if len(nums1) > len(nums2):
            return self.findMedianSortedArrays(nums2, nums1)
        # nums1 is shorter than nums2
        len1, len2 = len(nums1), len(nums2)
        left, right = 0, len1
        while left <= right:
            partitionA = (left + right) // 2
            partitionB = (len1 + len2) // 2 - partitionA
            print(partitionA, partitionB)
            first_left = float("-inf") if partitionA == 0 else nums1[partitionA - 1]
            first_right = float("inf") if partitionA == len1 else nums1[partitionA]
            second_left = float("-inf") if partitionB == 0 else nums2[partitionB - 1]
            second_right = float("inf") if partitionB == len2 else nums2[partitionB]

            if first_left <= second_right and second_left <= first_right:
                if (len1 + len2) % 2 == 0:
                    return (max(first_left, second_left) + min(first_right, second_right)) / 2
                else:
                    return min(first_right, second_right)
            elif first_left > second_right:
                right = partitionA - 1
            else:
                left = partitionA + 1
