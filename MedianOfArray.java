// Time complexity O( log min(n1, n2) )
// Space complexity  O(1)
// Runs on leetcode YES
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int low = 0;
        int high = n1;

        if(n2 < n1 ){
            return findMedianSortedArrays(nums2, nums1);
        }

        while (low <= high) {

            int mid = low + (high - low) / 2;
            int partX = mid;
            int partY = (n1 + n2) / 2 - partX;
            double x1, x2, y1, y2;
            if (partX == 0) {
                x1 = Integer.MIN_VALUE;
            } else {
                x1 = nums1[partX - 1];
            }
            if (partY == n2) {
                y2 = Integer.MAX_VALUE;
            } else {
                y2 = nums2[partY];
            }

            if (partX == n1) {
                y1 = Integer.MAX_VALUE;
            } else {
                y1 = nums1[partX];
            }

            if (partY == 0) {
                x2 = Integer.MIN_VALUE;
            } else {
                x2 = nums2[partY - 1];
            }

            if (x1 <= y2 && x2 <= y1) {
                // correct partitioning
                if ((n1 + n2) % 2 == 0) {
                    // even
                    return (Math.max(x1, x2) + Math.min(y1, y2)) / 2;
                } else {
                    //odd
                    return Math.min(y1, y2);
                }
            } else if (x1 > y2) {
                high = mid - 1;
            } else if (x2 > y1) {
                low = mid + 1;
            }
        }
        return 99.00;
    }
}