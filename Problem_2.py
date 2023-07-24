"""
Problem : 2

Time Complexity : O(log(n)) //n=length of smaller array
Space Complexity : O(1)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

The solution performing a binary search on the smaller array (nums1).

The binary search loop runs as long as low is less than or equal to high. Calculating the partition points partX and partY for nums1 and nums2, respectively.
These partition divide the arrays into two halves (left and right). It calculating four values, l1, r1, l2, and r2, 
which represent the elements to the left and right of partX and partY in nums1 and nums2, respectively. 
The values of l1, r1, l2, and r2 are chosen carefully to handle edge cases where the partition points are at the boundaries of the arrays.
It checks if the partitioning is correct by comparing l1 and r2, as well as l2 and r1. If both conditions are true, it means the partitioning is correct, and the median is found.
Depending on whether the total number of elements in nums1 and nums2 is even or odd, returning the appropriate median value.
If the partitioning is incorrect, adjusting the low and high pointers to converge to the correct partition point. This process continues until the correct partition is found.
"""

# Median of Two Sorted Arrays

class Solution(object):
    def findMedianSortedArrays(self, nums1, nums2):
        n1=len(nums1)
        n2=len(nums2)
        if n1==0 and n2==0:
            return 0.0

        if n1>n2:
            return self.findMedianSortedArrays(nums2,nums1)
        low=0
        high=n1
        while low<=high:
            partX=low+(high-low)/2
            partY=(n1+n2)/2-partX
            l1=float('-inf') if partX==0 else nums1[partX-1]
            r1=float('inf') if partX==n1 else nums1[partX]
            l2=float('-inf') if partY==0 else nums2[partY-1]
            r2=float('inf') if partY==n2 else nums2[partY]
            if l1<=r2 and l2<=r1:
                if (n1+n2)%2==0:
                    return (max(l1,l2)+min(r1,r2))/2.0
                else:
                    return min(r1,r2)
            elif l2>r1:
                low=partX+1
            else:
                high=partX-1
        return 