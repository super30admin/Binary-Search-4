# Problem 2 : Median of Two Sorted Arrays
# Time Complexity : O(log(min(m,n))) where m and n are size of two list
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
'''
None
'''

# Your code here along with comments explaining your approach
from typing import List
class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        # if the length of nums1 is greater than nums2 then swap since we doing binary on smaller list
        if len(nums1) > len(nums2):
            nums1, nums2 = nums2, nums1

        # find length of the lists
        m, n = len(nums1), len(nums2)
        # set the left to zero and right to legth of nums1 list
        left, right = 0, m
        # loop till left is less than or equal to right
        while(left <= right):
            # find the mid for nums1 ie partition 
            partition1 = (left + right) // 2
            # find the partition for second list using the partition of the first list
            partition2 = (m+n+1) // 2 - partition1
            # find the elements of both the list which will exactly left to the partitions
            maxLeft1 = float('-inf') if partition1 == 0 else nums1[partition1 - 1]
            maxLeft2 = float('-inf') if partition2 == 0 else nums2[partition2 - 1]

             # find the elements of both the list which will exactly right to the partitions
            minRight1 = float('inf') if partition1 == m else nums1[partition1]
            minRight2 = float('inf') if partition2 == n else nums2[partition2]

            '''
                since we need merged list as sorted so need to check the left element of the first should small than the 
                right element of the second list and left element of the second ist should be small than the right element
                of the first list
            '''
            if (maxLeft1 <= minRight2 and maxLeft2 <= minRight1):
                # checking the legth is odd
                if ((m+n)% 2 == 1):
                    # if the length is odd then median is the exact middle element 
                    # ie. max(left element from first list, left element from second list)
                    return max(maxLeft1, maxLeft2)
                else:
                    # if the length is even then median is the average of two middle elements
                    '''
                    first element = max(left element from first list, left element from second list)
                    second element = min(right element from first list, right element from second list)
                    median = (first element + second element) / 2
                    '''
                    return (max(maxLeft1, maxLeft2) + min(minRight1, minRight2)) / 2
            # if the left element of first list is greater than right element of second list then set right to partition - 1
            elif (maxLeft1 > minRight2):
                right = partition1 - 1
            # if the left element of second list is greater than right element of first list then set left to partition + 1
            else:
                left = partition1 + 1
        