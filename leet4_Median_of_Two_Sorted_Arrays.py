# Solution

# // Time Complexity : O(log(min(len(nums1),len(nums2)))) since we apply binary search on array with smaller size
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : None


# // Your code here along with comments explaining your approach
# Approach is to think of array elements as partitions(number of elements). Median divides array into two halfs. So we basically
# can do a binary search on array with lower length to see if all elements till there of first array and then some elements at 
# the start of the second array can be combined to form the first half of the result. If it cannot be combined then check if
# last element of first array is greater than first element of right half of second array, if true then move high = mid-1
# else move low = mid+1. Because it tells the combined array will not be sorted so we need to move it. If there are no such issues
# then based on the condition of total array length of result, if it is even or odd, find the median.
# MAIN THING IS CONSIDERING THAT WE NEED TO WORK WITH PARTITIONS(COUNT OF ELEMENTS) IN EACH SIDE OF THE FINAL ARRAY AND HOW TO
# DO THEM BY JUST USING ELEMENT COUNT SEPARATELY OF EACH ARRAY

import math

def findMedianSortedArrays( nums1, nums2):
        
    n1 = len(nums1)
    n2 = len(nums2)
    if n2<n1:
        return findMedianSortedArrays(nums2,nums1)

    low = 0
    high = n1

    while low<=high:
        xPart = (low+high)//2
        yPart = ((n1+n2)//2) - xPart 

        l1 = -math.inf if xPart == 0 else nums1[xPart-1]
        l2 = -math.inf if yPart == 0 else nums2[yPart-1]
        r1 = math.inf if xPart == n1 else nums1[xPart]
        r2 = math.inf if yPart == n2 else nums2[yPart]

        if l1<=r2 and l2<=r1:
            if ((n1+n2)%2 == 0):
                return ((max(l1,l2)+min(r1,r2))/2.0)
            else:
                return min(r1,r2)/1.0
        else:
            if l1>r2:
                high = xPart-1
            else:
                low = xPart+1

        # My FAILED index based solution
        # n1 = len(nums1)
        # n2 = len(nums2)
        # if n2>n1:
        #     return self.findMedianSortedArrays(nums2,nums1)

        # low = 0
        # high = min(n1,n2) - 1

        # mid = (low+high)//2
        # index2 = ((n1+n2)//2) - mid - 2

        # while mid<n1 and mid>=0 and index2>=0 and index2<n2:
        #     if (nums1[mid] <= nums2[index2+1]) and nums2[index2]<=nums1[mid+1]:
        #         if ((n1+n2)%2 == 0):
        #             return ((max(nums1[mid],nums2[index2])+min(nums1[mid+1],nums2[index2+1]))/2)
        #         else:
        #             return min(nums1[mid+1],nums2[index2+1])/1.0
        #     else:
        #         if nums1[mid]>nums2[index2+1]:
        #             mid -= 1
        #             index2 += 1
        #         else:
        #             mid += 1
        #             index2 -= 1
        
        # return 1.0

if __name__ == "__main__":
    nums1 = [1,3]
    nums2 = [2]
    print(findMedianSortedArrays( nums1, nums2))