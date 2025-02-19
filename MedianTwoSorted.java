// In this problem, since asked log time, we are doing binary search on smaller array only by doing partitions on both arrays,
// since we know there will be m+n elements in merged array and if divide the merged array into half we get the median. So, 
// picking some elements from the nums1 and remaining from nums2 for first half, checking if the values of l1<=r2 and l2<=r1,
// that means we have hit correct partition. And returning the ans, else moving left and right accordingly.

// Time Complexity : O(logm)
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no 
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Base case
        if (nums1 == null && nums2 == null) {
            return 0.0;
        }
        int m = nums1.length;
        int n = nums2.length;
        // Below will make sure that nums1 is having less elements always
        if (m > n) {
            return findMedianSortedArrays(nums2, nums1);
        }
        // Computing low and high
        int low = 0;
        int high = m;
        // While low<=high
        while (low <= high) {
            // Compute mid i.e. partition on nums1
            int partX = low + (high - low) / 2;
            // Based on how many we picked for first half from nums1, we decide how many to
            // pick from nums2
            int partY = (m + n) / 2 - partX;

            // Calculate l1 value before partition x in nums1,l2 value before partition y in
            // nums2,r1 value after partition x in nums1,r2 value after partition y in nums2

            // If we are at extremes of arrays take -infinity or infinity accordingly
            double l1 = partX == 0 ? Integer.MIN_VALUE : nums1[partX - 1];
            double r1 = partX == m ? Integer.MAX_VALUE : nums1[partX];
            double l2 = partY == 0 ? Integer.MIN_VALUE : nums2[partY - 1];
            double r2 = partY == n ? Integer.MAX_VALUE : nums2[partY];
            // If correct partition, that l1 l2 contains all elements for first half, so it
            // should be smaller than r1 r2
            if (l1 <= r2 && l2 <= r1) {
                // Check our total elements is odd than
                if ((m + n) % 2 != 0) {
                    // Return min of r1 r2
                    return Math.min(r1, r2);
                } else {
                    // Else if even - below
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2;
                }
            }
            // Else if we want smaller value of l1, move left since array is sorted in
            // ascending order
            else if (l1 > r2) {
                high = partX - 1;
            }
            // Else if we want bigger value of r1, move right since array is sorted in
            // ascending order
            else if (l2 > r1) {
                low = partX + 1;
            }
        }
        // Return anything, it will not come here
        return 33243.233;
    }
}