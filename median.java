// Time Complexity : O(log(min(m,n)))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
      int n1 = nums1.length;
      int n2 = nums2.length;
      if (n2 < n1)
          return findMedianSortedArrays(nums2, nums1);
      int l = 0;
      int r = n1;
      
      while (l <= r) {
          int p1 = l + (r - l) / 2;
          int p2 = ((n1 + n2) / 2 - p1);
          
          double l1 = p1 == 0 ? Integer.MIN_VALUE : nums1[p1 - 1];
          double l2 = p2 == 0 ? Integer.MIN_VALUE : nums2[p2 - 1];

          double r1 = p1 == n1 ? Integer.MAX_VALUE : nums1[p1];
          double r2 = p2 == n2 ? Integer.MAX_VALUE : nums2[p2];

          if (l1 <= r2 && l2 <= r1) {
              if ((n1 + n2) % 2 == 0) {
                  return (Math.max(l1, l2) + Math.min(r1, r2)) / 2;
              } else {
                  return Math.min(r1, r2);
              }
          } else if (l1 > r2) {
              r = p1 - 1;
          } else {
              l = p1 + 1;
          }

      }
      return 0.00;
  }
}