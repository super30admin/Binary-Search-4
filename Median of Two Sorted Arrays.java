// Use binary search on the smaller array (nums1) to partition both arrays into two halves such that all elements on the left half are less than or equal to all elements on the right half.
// At each step, calculate partX and partY (partitions of nums1 and nums2) and compare the max of left parts with the min of right parts to find the correct partition.
// Once a valid partition is found, compute the median based on whether the total number of elements is even or odd.

// Time Complexity:
// O(log(min(n1, n2))) — binary search on the smaller array.

// Space Complexity:
// O(1) — constant extra space.

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n1 > n2)
            return findMedianSortedArrays(nums2,nums1);
        int low = 0, high = n1;
        double res = 1.0;
        while(low <= high){
            int partX = low + (high - low)/2;
            int partY = (n1 + n2)/2 - partX;
            double X1 = partX == 0 ? Integer.MIN_VALUE : nums1[partX-1];
            double Y1 = partX == n1 ? Integer.MAX_VALUE : nums1[partX];
            double X2 = partY == 0 ? Integer.MIN_VALUE : nums2[partY-1];
            double Y2 = partY == n2 ? Integer.MAX_VALUE : nums2[partY];
            if(X1 <= Y2 && X2 <= Y1){
                if((n1+n2)% 2 == 0){
                    // even case
                    return (Math.min(Y1,Y2) + Math.max(X1,X2))/2;
                } else{
                    // odd case
                    return Math.min(Y1,Y2);
                }
            } else if(X1 > Y2){
                high = partX-1;
            } else{
                low = partX +1;
            }
        }

        return res;
    }
}
