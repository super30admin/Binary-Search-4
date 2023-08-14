// Time Complexity : O(log(min(m,n)))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 * 1. Find the partition in the smaller array using binary search and get the corresponding partition in the larger array.
 * 2. Check if the partition is correct by comparing the left and right elements of both the arrays.
 * 3. If the partition is correct, then check if the total length of the array is even or odd.
 * 4. If the total length is even, then return the average of the max of left elements and min of right elements else return the min of right elements.
 */

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        if(n > m)
            return findMedianSortedArrays(nums2, nums1);
        
        int low = 0, high = n;
        while(low <= high){
            int partX = low + (high-low)/2;
            int partY = (n+m)/2 - partX;
            double L1 = partX == 0 ? Integer.MIN_VALUE : nums1[partX-1];
            double R1 = partX == n ? Integer.MAX_VALUE : nums1[partX];
            double L2 = partY == 0 ? Integer.MIN_VALUE : nums2[partY-1];
            double R2 = partY == m ? Integer.MAX_VALUE : nums2[partY];
            if(L1 <= R2 && L2 <= R1){
                if((n+m) % 2 == 0){
                    return (Math.max(L1, L2) + Math.min(R1, R2)) / 2;
                }else {
                    return Math.min(R1, R2);
                }
            }else if(L1 > R2){
                high = partX - 1;
            }else {
                low = partX + 1;
            }
        }
        
        return 0.0;
    }
}