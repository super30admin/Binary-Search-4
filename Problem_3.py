"""
Time Complexity : O(log m) where m is length of smaller array
Space Complexity :O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


Here, the brute force solution would be to take 2 pointers, and keep on merging the 2 arrays until we reach
middle of the total length of the 2 arrays and then return the median depending upon if there are total odd values
or even. the time complexity of that approach would be approx O(m+n). An optimal approach would be binary search
on the smaller array, but not on values, it would be on partitions. We hypothetically create partitions between
all the values in both the arrays. We start doing binary search on smaller array and find the middle partition
which would be partitionx. Partitiony could be calculated using a formula. The thinking behind
this calculation is that there need to be almost same amount on values on both left and right side. Now when we
have both the values, we need to assgin 4 values, l1,l2,r1,r2. l1 is left value to partitionx and r1 is right value
to partitionx. Similarly with l2 and r2. Also, if they are extreme positions, we need to assign them inf or -inf.
After that, the condition that needs to be checked is, if l1<=r2 and l2<=r1. If that is the case, we can return our
median. In case we have odd values total, median would be the min of r1 and r2. In case we have total even
values, median would be mean of max of l1 and l2 and min of r1 and r2. We are doing min and max as we need to
find 2 values that can contest for median.At last, if the condition does not follow, we need to move low and 
find a new high and repeat the process untill we find our median.
"""


class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        n1 = len(nums1)
        n2 = len(nums2)
        if n1 > n2:
            return self.findMedianSortedArrays(nums2, nums1)
        low = 0
        high = n1
        while low <= high:
            partx = low+(high-low)//2
            party = (n1+n2)//2-partx
            if partx == 0:
                l1 = float('-inf')
            else:
                l1 = nums1[partx-1]
            if partx == n1:
                r1 = float('inf')
            else:
                r1 = nums1[partx]
            if party == 0:
                l2 = float('-inf')
            else:
                l2 = nums2[party-1]
            if party == n2:
                r2 = float('inf')
            else:
                r2 = nums2[party]
            if l1 <= r2 and l2 <= r1:
                # odd case
                if (n1+n2) % 2 != 0:
                    return min(r1, r2)
                else:
                    return (max(l1, l2)+min(r1, r2))/2
            elif l2 > r1:
                low = partx+1
            else:
                high = partx-1
