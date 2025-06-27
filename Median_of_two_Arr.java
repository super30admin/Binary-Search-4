/*
 * TC: O(min(m,n)), where m:nums1.length, n: nums2.length
 * SC: O(1)
 * 
 * Approach : Initally i will choose a arr which is min in size. then i will apply partitions on my nums1 by finding my mid and for finding the partition point for nums2 i will half the combined lenght subtracted  by partition X. And then i will check the elements at the partition on both the side  and for both the arr.
 * and keep updating my low and high. As soon as i fulfill my condition where, element on left of nums1 < element on right of nums2 and vice-versa. i will then check the total combined length  if even then average of  max from left part and min from right part else min from right part.
 */


class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length,n2 = nums2.length;
        if(n2 < n1) return findMedianSortedArrays(nums2,nums1);

        int low = 0, high = n1;
         
         while(low<=high){
            int mid = low + (high - low)/2;
            System.out.println("mid:"+mid);

            int partX = mid;
            int partY = (n1+n2)/2 - partX;

            int leftX = (partX == 0) ? Integer.MIN_VALUE : nums1[partX - 1];
            int rightX = (partX == n1) ? Integer.MAX_VALUE : nums1[partX];
            int leftY = (partY == 0) ? Integer.MIN_VALUE : nums2[partY - 1];
            int rightY = (partY == n2) ? Integer.MAX_VALUE : nums2[partY];

            if(leftX <= rightY && leftY <= rightX){
                if((n1+n2)%2 == 0) return (Math.max(leftX,leftY) + Math.min(rightX,rightY))/2.0;
                else return  Math.min(rightX,rightY);
            }
            else if(leftX > rightY)
                high = partX-1;
            else
                low = partX+1;
         }
    return -1.0000;   
    }
}