// Time Complexity: O(log(min(m, n)))
//Space Complexity: O(1)

/*
 * create partition for both array and if the left values are less than right
 * then we found our partition else we move left or right using binary search.
 * if the total elements are even we get the average else the min of right.
 */

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        if(n == 0 && m == 0) return 0.0;
        if(n > m) return findMedianSortedArrays(nums2, nums1);
        int low = 0;
        int high = n;

        while(low <= high){
            int partX = low + (high-low)/2;
            int partY = (m+n)/2 - partX;
            double L1 = partX == 0 ? Integer.MIN_VALUE: nums1[partX - 1];
            double R1 = partX == n ? Integer.MAX_VALUE: nums1[partX];
            double L2 = partY == 0 ? Integer.MIN_VALUE: nums2[partY - 1];
            double R2 = partY == m ? Integer.MAX_VALUE: nums2[partY];

            if(L1 <= R2 && L2 <= R1){
                if((n+m)%2 == 0){
                    return (Math.max(L1, L2) + Math.min(R1, R2)) / 2;    
                }
                else{
                    return Math.min(R1, R2);
                }
            }
            else if(L1 > R2){
                high = partX - 1;
            }
            else{
                low = partX + 1;
            }
        }
        return -1;
    }
}