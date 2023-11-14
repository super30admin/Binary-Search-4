/* Time Complexity : O(log n) 
*   n - min(n1, n2) 
*   n1 - len of array nums1
*   n2 - len of array nums2 */
/* Space Complexity : O(1) */
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        // To perform binary search on the smaller array
        if(n1 > n2) return findMedianSortedArrays(nums2, nums1);
        int low = 0;
        int high = n1;
        while(low <= high){
            int partX = low + (high - low)/2;
            int partY = (n1+n2)/2 - partX;

            int L1 = partX == 0 ? Integer.MIN_VALUE : nums1[partX - 1];
            int R1 = partX == n1 ? Integer.MAX_VALUE : nums1[partX];
            int L2 = partY == 0 ? Integer.MIN_VALUE : nums2[partY - 1];
            int R2 = partY == n2 ? Integer.MAX_VALUE : nums2[partY];

            if(L1 <= R2 && L2 <= R1){ //correct partition
                if((n1+n2) % 2 == 0){ // imaginary array len is even
                    return (Math.max(L1, L2) + Math.min(R1, R2))/2.0;
                } else { // imaginary array len is odd
                    return Math.min(R1, R2);
                }
            }
            else if(L2 > R1){// move partition towards right
                low = partX + 1;
            }
            else{// L1 > R2 // move partition towards left
                high = partX - 1;
            }            
        }
        return 11.11;
    }
}