// Time Complexity : O(log(min(m,n)))
// Space Complexity :  O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, had to learn

/*
 * 4. Median of Two Sorted Arrays
 * 
 * We do a binary search on the smaller array(gives the least time complexity), and determine where my partition should be on the larger array.
 * 
 * L1, L2  represent the end elements of partition1  <-> R1 , R2 start elements of partition2
 * 
 * Mean would be
 * Even? Avg of max(L1, L2) & min(R1,R2) ;
 *  the progression of arry would be such that at 
 * the end of partition1 should end with maximum of L1, L2  [1,2,3]
 * the start of partition2 should start with min of R1, R2  [4,5,6]
 * 
 * Odd? Maximum of R1, R2 (since we started with a smaller array for Binary Search)
 * 
 * If L1 > R2 ? i.e., partitionX should shift left; so high= partX-1 (means number lies in the left portion of array)
 * 
 * 
 * if(L1<=R2) & 
 * 
 * THings to note: 
 * for a given array of size n; number of partitions are 0->n ; number of indexes are 0->n-1
 * 
 *  
 * Edge cases:
 * If partition is at 0; we return Integer.MIN_VALUE; else return nums[partition-1] ; think if partition-1 =0 then its an edge case or else return  nums[partition-1]
 * If partition is at n; we return Integer.MAX_VALUE; else return nums[partition]
 * Using double L1 : Using double for L1, R1, L2, and R2 ensures that the algorithm handles edge cases, fractional results, and large values correctly, providing accurate median calculations for the two sorted arrays.
 */

import java.util.*;

public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if (n2 > n1)
            return findMedianSortedArrays(nums2, nums1); // n1 should be smaller
        int low = 0;
        int high = n1; // smaller

        while (low <= high) {
            int partX = low + (high - low) / 2;
            int partY = (n1 + n2) / 2 - partX;

            double L1 = partX == 0 ? Integer.MIN_VALUE : nums1[partX - 1];
            double R1 = partX == n1 ? Integer.MAX_VALUE : nums1[partX];

            double L2 = partY == 0 ? Integer.MIN_VALUE : nums2[partY - 1];
            double R2 = partY == n2 ? Integer.MAX_VALUE : nums2[partY]; // type double is important

            if (L1 <= R2 && L2 <= R1) {// don't miss equal to condition
                // found median
                if ((n1 + n2) % 2 == 0) {
                    return (Math.max(L1, L2) + Math.min(R1, R2)) / 2;
                } else {
                    return Math.min(R1, R2);
                }
            } else if (L1 > R2) {
                high = partX - 1;
            } else {
                low = partX + 1;
            }

        }

        return 0.0;

    }
}
