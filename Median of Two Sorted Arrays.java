// Time Complexity :O(min(logn, logm)) 
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

class Solution {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    if (nums1 == null || nums2 == null)
      return 0;
    int n1 = nums1.length, n2 = nums2.length;

    if (n1 > n2) // to maintain smaller array in n1
      return findMedianSortedArrays(nums2, nums1);

    int low = 0, high = n1;
    while (low <= high) {
      int partx = low + (high - low) / 2;
      int party = (n1 + n2) / 2 - partx;

      double l1 = partx - 1 < 0 ? Integer.MIN_VALUE : nums1[partx - 1];
      double l2 = party - 1 < 0 ? Integer.MIN_VALUE : nums2[party - 1];
      double r1 = partx == n1 ? Integer.MAX_VALUE : nums1[partx];
      double r2 = party == n2 ? Integer.MAX_VALUE : nums2[party];

      if (l1 <= r2 && l2 <= r1) {
        // even
        if ((n1 + n2) % 2 == 0) {
          return (Math.max(l1, l2) + Math.min(r1, r2)) / 2;
        }
        // odd
        return Math.min(r1, r2);
      } else if (l1 > r2) {
        high = partx - 1;
      } else {
        low = partx + 1;
      }

    }
    return -10;
  }
}