// In this problem, we use binary search to find the median of two sorted arrays. We perform binary search on the smaller array. We calculate the partition of the smaller array and the
// corresponding partition of the larger array. We then check if the maximum element on the left side of the partitions is less than or equal to the minimum element on the right side of the partitions.
// If the condition is satisfied, we have found the correct partition and we can calculate the median based on the max element on the left and min element on the right. If the condition is not satisfied, 
// we adjust the binary search range accordingly.
// Time Complexity: O(log(min(n, m))) where n and m are the sizes of the two input arrays.
// Space Complexity: O(1) as we are using only a constant amount of extra space.

class Solution {        
fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val n1 = nums1.size
        val n2 = nums2.size

        if (n1 > n2) {
            return findMedianSortedArrays(nums2, nums1)
        }

        var low = 0
        var high = n1

        while (low <= high) {
            val partX = low + (high - low) / 2
            val partY = (n1 + n2 + 1) / 2 - partX

            val L1 = if (partX == 0) Int.MIN_VALUE else nums1[partX - 1]
            val R1 = if (partX == n1) Int.MAX_VALUE else nums1[partX]

            val L2 = if (partY == 0) Int.MIN_VALUE else nums2[partY - 1]
            val R2 = if (partY == n2) Int.MAX_VALUE else nums2[partY]

            if (L1 <= R2 && L2 <= R1) {
                return if ((n1 + n2) % 2 == 0) {
                    (maxOf(L1, L2) + minOf(R1, R2)) / 2.0
                } else {
                    maxOf(L1, L2).toDouble()
                }
            } else if (L1 > R2) {
                high = partX - 1
            } else {
                low = partX + 1
            }
        }

        return 0.0
    }
}
