// Time Complexity : O(log(min(m,n)))
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

/*
 * Approach
 * we are using binary search to solve the problem, not the regular Binary search
 * 
 * Firstly median is the middle ele of an array, so goal is to middle without actualy merging the array
 * so using "mid"(partX) of the search as one part of and use that to calculate partY(location were we should split the second array)
 * once we have the two parts we use them to calculate l1,r1 and l2, r2, basically "l" is the left part of the array and "r" is the right part
 * if "partition of array" is at "0" basically start of the array we take "l1 or l2" and MIN_VALUE or "partition of array" is at "length" basically last element of the
 * array we at MAX_VALUE, we this so that it does not fail the check,
 * 
 * to know are have slip the arrays in proper partition, we check l1<=r2 and l2<=r1 if yes, then are check is both array
 * combined are of odd len or even based on that check we return the value
 * 
 * if l1<=r2 and l2<=r1 fails, l2> r1 we move low else high
 * 
 */

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if (n1 > n2) {
            return findMedianSortedArrays(nums2, nums1); // to get the smaller array among the two
        }
        int low = 0;
        int high = n1;
        while (low <= high) {
            int partX = low + (high - low) / 2;
            int partY = (n1 + n2) / 2 - partX;
            double l1 = partX == 0 ? Integer.MIN_VALUE : nums1[partX - 1];
            double r1 = partX == n1 ? Integer.MAX_VALUE : nums1[partX];

            double l2 = partY == 0 ? Integer.MIN_VALUE : nums2[partY - 1];
            double r2 = partY == n2 ? Integer.MAX_VALUE : nums2[partY];

            if (l1 <= r2 && l2 <= r1) {
                if ((n1 + n2) % 2 == 0) {
                    return (Math.min(r1, r2) + Math.max(l1, l2)) / 2; // even
                } else {
                    return Math.min(r1, r2);
                }
            } else if (l2 > r1) {
                low = partX + 1;
            } else {
                high = partX;
            }
        }
        return 11.2;
    }
}