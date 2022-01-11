// Time Complexity = O(log m), where m is the length of smaller list
// Space complexity = O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0 && nums2.length == 0) return 0.0;

        // make nums1 smaller array always
        if (nums2.length < nums1.length) {
            findMedianSortedArrays(nums2, nums1);
        }

        int m=nums1.length, n=nums2.length;
        int low=0, high=m;          //since partition goes upto m

        // use binary search here on nums1, and adjust the partition accordingly,
        // where left elements are smaller than the right elements
        while (low <= high) {
            // calculate partition on nums1
            int part1 = low+(high-low)/2;
            int part2 = ((m+n)/2)-part1;

            // Mark l1, l2, r1, r2: If they are at the ends mark them -INFINITY or INFINITY
            // otherwise its in the format 0<n1>1<n2>2
            double l1 = (part1 == 0) ? Integer.MIN_VALUE : nums1[part1-1];
            double r1 = (part1 == m) ? Integer.MAX_VALUE : nums1[part1];
            double l2 = (part2 == 0) ? Integer.MIN_VALUE : nums2[part2-1];
            double r2 = (part2 == n) ? Integer.MAX_VALUE : nums2[part2];

            // This is the desired case, where left elements are smaller than right
            if(l1 <= r2 && l2 <= r1) {
                // even case
                if ((m+n)%2 == 0) {
                    // so that left side and right side elements are as close to the center as possible
                    return (Math.max(l1,l2)+Math.min(r1,r2))/2;
                }
                // odd case
                else {
                    // since its a right heavy arrangement, return the smallest element on the right side
                    return Math.min(r1,r2);
                }
            }
            else if(l1 > r2) {
                // if left side of nums1 if greater than right side of nums2, we move to the right side in binary search
                high = part1-1;
            }
            else if (l2 > r1) {
                // if left side of nums2 if greater than right side of nums1, we move to the left side in binary search
                low = part1+1;
            }
        }

        // will not reach this point
        return 0;
    }
}