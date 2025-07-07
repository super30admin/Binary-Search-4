/**
 * Leetcode 4. Median of Two Sorted Arrays
 * Link: https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 */
public class MedianTwoSortedArray {
    /**
     * Since both arrays are sorted we can do binary search on smaller array to find a mid point. Instead of using midpoint
     * for traditional direct comparison we will use it to find possible splits/partitions in both the arrays. For a given
     * mid-point we will know total elements on the left of it and we can choose another partition in longer array by
     * (total elements left of potential combined array - elements on left of partition in small array). This works as boundary
     * and we then compare immediate neighbors of this boundary/partition to check if elements were merged at that point would
     * have been in sorted order or not. If not, we can move our low and high accordingly in the smaller list to keep doing
     * binary search until we find partition which is sorted.
     *
     * TC: O(log(n1)) n1 is length of smaller array
     * SC: O(1)
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        if (n1 > n2) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int low = 0;
        int high = n1;

        while (low <= high) {
            int partitionX = low + (high - low) / 2;
            int partitionY = (n1 + n2) / 2 - partitionX;
            double x1 = partitionX == 0 ? Integer.MIN_VALUE : nums1[partitionX - 1];
            double y1 = partitionX == n1 ? Integer.MAX_VALUE : nums1[partitionX];
            double x2 = partitionY == 0 ? Integer.MIN_VALUE : nums2[partitionY - 1];
            double y2 = partitionY == n2 ? Integer.MAX_VALUE : nums2[partitionY];

            if (x1 <= y2 && x2 <= y1) {
                //found answer
                if ((n1 + n2) % 2 == 0) { //even
                    return (Math.max(x1, x2) + Math.min(y1, y2)) / 2;
                } else { //odd
                    return Math.min(y1, y2);
                }
            } else if (x1 > y2) {
                high = partitionX - 1;
            } else {
                low = partitionX + 1;
            }
        }
        return 0.0;
    }
}
