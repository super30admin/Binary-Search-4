// Time Complexity : O(log(min(m,n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//We use binary search on the smallest array that is given and find the partition point on that array
// Using the partition point on samllest array we find the partition point on the bigger array
// We then compare if the left partition elements are samller than the right partition if yes we find the median which will be then calculated based on even and odd array length
//If not we subsequently move the low and high pointers on smaller array


class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        if(n1 > n2) return findMedianSortedArrays(nums2, nums1);

        int low = 0;
        int high = n1;

        while(low <= high) {
            int partX = low + (high-low)/2;
            int partY = (n1+n2)/2 - partX;

            double l1 = partX == 0 ? Integer.MIN_VALUE : nums1[partX - 1];
            double r1 = partX == n1 ? Integer.MAX_VALUE : nums1[partX];
            double l2 = partY == 0 ? Integer.MIN_VALUE : nums2[partY - 1];
            double r2 = partY == n2 ? Integer.MAX_VALUE : nums2[partY];

            if(l1 <= r2 && l2 <= r1) {
                //found a median
                if((n1+n2) % 2 == 0) {
                    //even array
                    return (Math.min(r1, r2) + Math.max(l1, l2))/2;
                } else {
                    return Math.min(r1,r2);
                }
            } else if(l2 > r1) {
                low = partX + 1;
            } else {
                high = partX - 1;
            }
        }
        return -1;  
    }
}
