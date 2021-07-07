package com.ds.rani.bs;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * <p>
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * <p>
 * You may assume nums1 and nums2 cannot be both empty.
 * <p>
 * Example 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * The median is 2.0
 * Example 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * The median is (2 + 3)/2 = 2.5
 */

//Approach:median is the middle element combinely from both the arrays, so I should parttion both the arrays in such a way that
//combined left elements are less than combined right elements and the number of elements should be equal in both partition

//Time Complexity:log(n) where n=min(len(nums1),len(nums2))
//Space complexity:o(1)
public class MeadianOfSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int x = nums1.length;
        int y = nums2.length;

        if (x > y) {
            return findMedianSortedArrays( nums2, nums1 );
        }

        int lo = 0;
        int hi = x;
        double median = 0;

        while (lo <= hi) {
            // partition point for first array
            int partitionX = (lo + hi) / 2;
            //actual median will be (x+y)/2 element so in left part of x and y combinely I should have(x+y)/2 elements,
            // for left part I already took  partitionx elements so I will have

            int parttionY = (x + y + 1) / 2 - partitionX;

            //So now I parttioned array x and y at partitionX and partitionY index
            //maximum from left side in array x
            //if partitionX is 0 it means nothing is there on left side. Use -INF for maxLeftX
            //if partitionX is length of input then there is nothing on right side. Use +INF for minRightX
            int l1 = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int r1 = (partitionX == x) ? Integer.MAX_VALUE : nums1[partitionX];
            int l2 = (parttionY == 0) ? Integer.MIN_VALUE : nums2[parttionY - 1];
            int r2 = (parttionY == y) ? Integer.MAX_VALUE : nums2[parttionY];

            if (l1 <= r2 && l2 <= r1) {
                //total evn numbers available
                if ((x + y) % 2 == 0) {
                    return ((double) Math.max( l1, l2 ) +
                            Math.min( r1, r2 )) / 2;
                    //total numbers are odd, so extra number will be available at left side,so take max of left
                } else {
                    return Math.max( l1, l2 );
                }

            } else if (l1 > r2) {
                hi = partitionX - 1;
            } else {
                lo = partitionX + 1;
            }

        }
        return 0;
    }
}
