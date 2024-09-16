// Time Complexity : O(  log n) n = elements in array.
 
// Space Complexity : O(1) or O(log n ) using the recursive stack or depth of tree of recursive stack.


// Did this code successfully run on Leetcode :yes. 

// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//  do a binary search and recursion ;

//Runtime: 2 ms, faster than 99.82% of Java online submissions for Median of Two Sorted Arrays.
//Memory Usage: 40.1 MB, less than 96.70% of Java online submissions for Median of Two Sorted Arrays.
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int lengthNums1 = nums1.length;
    int lengthNums2 = nums2.length;

    if ((lengthNums1 + lengthNums2) % 2 == 0) {
      double med1 =
          (double)
              medianSortedArrays(
                  nums1, 0, lengthNums1, nums2, 0, lengthNums2, (lengthNums1 + lengthNums2) / 2);
      double med2 =
          (double)
              medianSortedArrays(
                  nums1,
                  0,
                  lengthNums1,
                  nums2,
                  0,
                  lengthNums2,
                  (lengthNums1 + lengthNums2) / 2 + 1);

      return (med1 + med2) / 2;
    } else {
      return medianSortedArrays(
          nums1, 0, lengthNums1, nums2, 0, lengthNums2, (lengthNums1 + lengthNums2) / 2 + 1);
    }
  }

  private int medianSortedArrays(
      int[] nums1, int startA, int endA, int[] nums2, int startB, int endB, int k) {
    int n = endA - startA;
    int m = endB - startB;

    if (n <= 0) return nums2[startB + k - 1];
    if (m <= 0) return nums1[startA + k - 1];
    if (k == 1) return nums1[startA] < nums2[startB] ? nums1[startA] : nums2[startB];

    int midA = (startA + endA) / 2;
    int midB = (startB + endB) / 2;

    if (nums1[midA] <= nums2[midB]) {
      if (n / 2 + m / 2 + 1 >= k)
        return medianSortedArrays(nums1, startA, endA, nums2, startB, midB, k);
      else
        return medianSortedArrays(nums1, midA + 1, endA, nums2, startB, endB, k - n / 2 - 1);
    } else {
      if (n / 2 + m / 2 + 1 >= k)
        return medianSortedArrays(nums1, startA, midA, nums2, startB, endB, k);
      else return medianSortedArrays(nums1, startA, endA, nums2, midB + 1, endB, k - m / 2 - 1);
    }
  }
}