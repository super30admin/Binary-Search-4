//since the time complexity is O(log(m+n)) -> means binary search
//brute force -> merge two sorted arrays and then determine the median
// optimize -> use two pointers
// if m > n then likely the solution is in m else solution is in n
// if m and n are equal then we want to have a pointer start of second array consisting of larger elements
// and start of the array consisting of smaller elements
// attempting to determine where i want to run the binary search?
// SC: O(1)
// TC: O(log(m+n))

class Solution {

  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int xlen = nums1.length;
    int ylen = nums2.length;
    if (xlen > ylen) {
      // we want nums1 to be shorter one
      return findMedianSortedArrays(nums2, nums1);
    }

    int left = 0;
    int right = xlen;
    int partX, partY;
    int maxLeftX;
    int minRightX;
    int maxLeftY;
    int minRightY;

    while (left <= right) { // standard binary search
      partX = (left + right) / 2;

      partY = (xlen + ylen + 1) / 2 - partX;

      if (partX == 0) {
        maxLeftX = Integer.MIN_VALUE;
      } else {
        maxLeftX = nums1[partX - 1];
      }

      if (partX == xlen) {
        minRightX = Integer.MAX_VALUE;
      } else {
        minRightX = nums1[partX];
      }

      if (partY == 0) {
        maxLeftY = Integer.MIN_VALUE;
      } else {
        maxLeftY = nums2[partY - 1];
      }

      if (partY == ylen) {
        minRightY = Integer.MAX_VALUE;
      } else {
        minRightY = nums2[partY];
      }

      if (maxLeftX <= minRightY && maxLeftY <= minRightX) { // correct partition found!
        if ((xlen + ylen) % 2 == 0) { // even case
          return (
            (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) /
            2.0
          );
        } else {
          return Math.max(maxLeftX, maxLeftY);
        }
      } else if (maxLeftX > minRightY) { // reduce bounds
        right = partX - 1;
      } else {
        left = partX + 1;
      }
    }

    return 0.0;
  }
}
