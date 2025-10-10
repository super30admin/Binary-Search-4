// Time Complexity : O(log(min(m,n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

/**
 * Doing the binary search on partition on smaller array to find the partition where all elements on the left half will be smaller than all elements on right half for both arrays combined.
 */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        if (n1 > n2) {
            // doing the binary search in smaller array
            return findMedianSortedArrays(nums2, nums1);
        }

        int low = 0;
        int high = n1;
        while (low <= high) {
            // finding how many elements we are taking from each array for partitions
            int partX = low + (high - low) / 2;
            int partY = (n1 + n2) / 2 - partX;
            double l1 = partX == 0 ? Integer.MIN_VALUE : nums1[partX - 1];
            double r1 = partX == n1 ? Integer.MAX_VALUE : nums1[partX];
            double l2 = partY == 0 ? Integer.MIN_VALUE : nums2[partY - 1];
            double r2 = partY == n2 ? Integer.MAX_VALUE : nums2[partY];

            // match found
            if (l1 <= r2 && l2 <= r1) {
                //even numbers will have average of middle 2 elements
                if ((n1 + n2) % 2 == 0) {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2;
                } else {
                    //odd numbers will have the median on right side since we have an extra element in ride side due to partX,partY split
                    return Math.min(r1, r2);
                }
            } else if (l1 > r2) {
                high = partX;
            } else {
                low = partX + 1;
            }
        }

        //execution won't reach here
        return 15.0;
    }
}