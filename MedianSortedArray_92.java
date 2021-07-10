// Time Complexity : O(log(n)), where n is the size of smallest array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :    No
package binarySearch4;

public class MedianSortedArray_92 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        //if nums1 length is > nums2 then swap nums1 and nums2 
        //to always have the nums1 smaller length
        if (n1 > n2) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int low = 0;
        int high = n1;
        while (low <= high) {
            //partition nums1
            int partX = low + (high - low) / 2;
            //partition nums2
            int partY = (n1 + n2) / 2 - partX;
            //lhs and rhs of partition for nums1
            double l1 = partX == 0 ? Integer.MIN_VALUE : nums1[partX - 1];
            double r1 = partX == n1 ? Integer.MAX_VALUE : nums1[partX];
            //lhs and rhs of partition for nums2
            double l2 = partY == 0 ? Integer.MIN_VALUE : nums2[partY - 1];
            double r2 = partY == n2 ? Integer.MAX_VALUE : nums2[partY];
            //check if it is correct median
            if (l1 <= r2 && l2 <= r1) {
                //this is correct median then return values
                if ((n1 + n2) % 2 != 0) {
                    //if sum of two array length is not even
                    return Math.min(r1, r2);
                } else {
                    //if sum of two array is even
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2;
                }

            } else if (l1 > r2) {//if this is true reduce high to partX -1 
                high = partX - 1;
            } else {
                low = partX + 1;
            }
        }
        return 1.0;
    }

}
