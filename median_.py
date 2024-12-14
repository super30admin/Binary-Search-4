"""
Approach1: 2 pointers, merge the array and find median
TC: merge -> O(m+n)

Approach2:
Step1: Find partitions in both the arrays such that after applying, the merged array is divided into 2 equal halves.
Step2: Now to find the median, partition in the merged array should be such that all the elements on the right of
partition in the merged are smaller than all elements on the left.

nums1 = [1,2,4,5,7], nums2 = [3,6,9,10,11]
first arr is partitioned into 1,2,4 | 5,7
seconds arr is partitioned into 3,4 | 9,10,11
In the merged arr:  1,2,4  |  5,7
                       3,4 | 9,10,11
both have equal number of elements.

for n elements: number of partition are : n+1
partition index: 0 to n
array index: 0 to n-1
if partX is known then partY = (n1+n2)//2 - partX, n1 = len(arr1) and n2 = len(arr2)
if (n1+n2) is even, arrays can be partitioned into 2 halves.
if odd, then one half will have one extra element, need to keep track of it, to find the median

Step3: make sure n1 is always smaller than n2. THat is, we apply partition on n1 and find partition on n2.
THis is to avoid out of bound error.
Step4: Apply binary search on partitions of the smaller array. Find the mid-partition from n1 and then using
formula partY = (n1+n2)//2 - partX find partition index in n2.
How to update lo and hi?
In the merged arr: 1,2,4 | 5,7
                       3,6 | 9,10,11
By comparing (4 and 9), (6 and 5).
4 < 9 thus correct position
But 6 > 5, 6 should have been in the left half, and 5 should have been in the right half. THus, move the partition to
right.
If the mid is at correct position, find median.
"""


class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:

        # to apply binary search on the smaller array, swap
        n1 = len(nums1)
        n2 = len(nums2)
        if n1 > n2:
            nums1, nums2 = nums2, nums1
            # swap the lengths also
            n1, n2 = n2, n1

        # print("n1: ",n1, " n2:", n2)

        lo = 0
        hi = n1  # no n1-1, since number of partitions = n1
        # binary search on partition index
        while lo <= hi:
            # mid partiton
            partX = lo + (hi - lo) // 2
            # partiton in n2 based on partition in n1
            partY = (n1 + n2) // 2 - partX

            # print("partX: ",partX, " partY:", partY)

            # get the elements from both array
            n1_left = float("-inf") if partX == 0 else nums1[partX - 1]
            n1_right = float("inf") if partX == n1 else nums1[partX]
            n2_left = float("-inf") if partY == 0 else nums2[partY - 1]
            n2_right = float("inf") if partY == n2 else nums2[partY]

            # compare the number
            if n1_left > n2_right:
                hi = partX - 1

            elif n1_right < n2_left:
                lo = partX + 1

            # carefull about the equal to sign
            elif n1_left <= n2_right and n1_right >= n2_left:
                # check length of mergred array
                if (n1 + n2) % 2 == 0:
                    return (max(n1_left, n2_left) + min(n2_right, n1_right)) / 2
                else:
                    # one extra element will always lie in right half, since
                    # n1 is always smaller than n2
                    return min(n2_right, n1_right)

