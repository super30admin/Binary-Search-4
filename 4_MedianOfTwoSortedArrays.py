"""
Leetcode-https://leetcode.com/problems/median-of-two-sorted-arrays/
TC O(log(min(n1, n2))), SC O(1)
Challenge- Understanding binary search solution and tuning it on different scenarios.
Lecture-https://www.youtube.com/watch?v=gmLBi4J906A
FAQ-


Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).


Example 1:
Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.

Example 2:
Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.


Constraints:
nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-10^6 <= nums1[i], nums2[i] <= 10^6
"""
import sys


class Solution:
    """
    Ideation-Partition using Binary search. TC O(log(min(n1, n2))), SC O(1)

    The idea is to put a partition at one of the array and the other array would be partition itself satisying the elements in the partition are half of the total combined array size.

    Once you partition, check for all the elements on the left side of partition are smaller than one to the right.
    To verify this, we compare the nums1[l1] < nums2[r2] and nums1[l2] < nums2[r1], since all the other elements are already smaller given the sorted arrays.
    If nums1[l1] < nums2[r2] is not true, we want to move our partition to the left to decrease l1 and increase r1 to be able to reach our satisfying rule. Hence, high = mid - 1, pruning all right partitions making the problem O(logN). Similarlym if nums1[l2] < nums2[r1] is not true, you move your partition to the right of the mid. Hence, low = mid + 1.
    When comparing the satisfied conditions, our partition could be extremes and we might not have either of l1, l2, r1, r2, consider comparing it with smallest value of integer for l1, l2, and largest value for r1, r2.

    Once the correct partition is found and length of combined elements is odd, our median (middle) would be min(r1, r2), i.e. our next element, first smallest element on right partition.
    else, if length is even, our median would be average of last element in first partitiona and first element in second, i.e. (max(l1, l2) + min(r1, r2)) // 2.

    NOTE- Always perform the binary partition on smaller size array to have better time complexity.
"""

    def findMedianSortedArrays(self, nums1, nums2):
        m, n = len(nums1), len(nums2)
        # finding right partition using binary search
        if m > n:
            # Always perform binary search on smaller array
            return self.findMedianSortedArrays(nums2, nums1)

        low, high = 0, len(nums1)
        while low <= high:
            xPar = low + (high - low) // 2
            yPar = (m + n) // 2 - xPar
            vl1 = -sys.maxsize if xPar == 0 else nums1[xPar - 1]
            vr1 = sys.maxsize if xPar == m else nums1[xPar]
            vl2 = -sys.maxsize if yPar == 0 else nums2[yPar - 1]
            vr2 = sys.maxsize if yPar == n else nums2[yPar]
            if vl1 <= vr2 and vl2 <= vr1:
                if (m + n) % 2 != 0:
                    return min(vr1, vr2) / 1.0
                else:
                    return (max(vl1, vl2) + min(vr1, vr2)) / 2.0
            elif vl1 > vr2:
                high = xPar - 1
            # if vl2 > vr1
            else:
                low = xPar + 1

        # A partition will always exist unless both arrays are empty
        return -1

    def binaryPartition(self, x, y):
        # we perform binary partition on x always.
        l, h = 0, len(x) - 1

        """
        Ideation- Two pointer merge, TC O((m + n) / 2), SC O((m + n) / 2)
        Our median is middle of the combine sorted array, we can stop our sorting at middle. We also, need average of middle and middle + 1 for even, so our desired length is middle + 1.
        """

        def findMedianSortedArrays1(self, nums1, nums2):
            combArr = []
            m, n = len(nums1), len(nums2)
            p1, p2 = 0, 0
            combMidIndex = (m + n) // 2 + 1
            # terminate when middle is found or either of pointers reach the end
            while len(combArr) < combMidIndex and p1 < m and p2 < n:
                if nums1[p1] < nums2[p2]:
                    combArr.append(nums1[p1])
                    p1 += 1
                else:
                    combArr.append(nums2[p2])
                    p2 += 1

            # if either of pointer is out of bound, add the remaining array to our combArr
            while len(combArr) < combMidIndex and p1 < m:
                combArr.append(nums1[p1])
                p1 += 1

            while len(combArr) < combMidIndex and p2 < n:
                combArr.append(nums2[p2])
                p2 += 1

            if (m + n) % 2 != 0:
                return combArr[-1] / 1.0
            else:
                return (combArr[-1] + combArr[-2]) / 2.0


arr1, arr2 = [2, 3, 4, 5], [1]
median = Solution().findMedianSortedArrays(arr1, arr2)
print(median)
