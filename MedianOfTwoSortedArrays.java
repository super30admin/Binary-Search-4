//https://leetcode.com/problems/median-of-two-sorted-arrays
/*
Time: O(logm)  m is length of smaller array
Space: O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if (nums1.length > nums2.length)
            return findMedianSortedArrays(nums2, nums1); // always keep nums1 larger

        int lengthA = nums1.length;
        int lengthB = nums2.length;

        int low = 0;
        int high = lengthA;

        while (low <= high) {
            int partitionA = (low + high) / 2;
            int partitionB = (lengthA + lengthB + 1) / 2 - (partitionA); // +1 here for the odd case, ensures extra elem
                                                                         // on left

            int maxLeftA = partitionA == 0 ? Integer.MIN_VALUE : nums1[partitionA - 1]; // -1 because if partitionA is
                                                                                        // 1, it means there is one
                                                                                        // element in the left of the
                                                                                        // partition
            int minRightA = partitionA == lengthA ? Integer.MAX_VALUE : nums1[partitionA]; // not -1 because it's to the
                                                                                           // right of the partition

            int maxLeftB = partitionB == 0 ? Integer.MIN_VALUE : nums2[partitionB - 1];
            int minRightB = partitionB == lengthB ? Integer.MAX_VALUE : nums2[partitionB];

            if (maxLeftA <= minRightB && maxLeftB <= minRightA) {
                if ((lengthA + lengthB) % 2 == 0)
                    return ((double) Math.max(maxLeftA, maxLeftB) + Math.min(minRightA, minRightB)) / 2;

                else
                    return (double) Math.max(maxLeftA, maxLeftB); // because we found that number in the middle

            }

            else if (maxLeftA > minRightB) // go left
                high = partitionA - 1;

            else
                low = partitionA + 1;

        }

        throw new IllegalArgumentException();
    }

}
