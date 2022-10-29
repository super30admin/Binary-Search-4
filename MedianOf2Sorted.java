// Time Complexity : O(log m)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if((nums1 == null && nums2 == null) || (nums1.length == 0 && nums2.length == 0)) return 0.0;

        int m = nums1.length;
        int n = nums2.length;

        if(n<m) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int l = 0;
        int h = m;

        while(l<=h) {
            int partX = l+(h-l)/2;

            int partY = (m+n)/2 - partX;

            double l1 = partX == 0 ? Integer.MIN_VALUE : nums1[partX-1];   //if index is 1 we need to provide 0th element
            double l2 = partY == 0 ? Integer.MIN_VALUE : nums2[partY-1];
            double r1 = partX == m ? Integer.MAX_VALUE : nums1[partX];
            double r2 = partY == n ? Integer.MAX_VALUE : nums2[partY];

            if(l1 <= r2 && l2 <=r1) {
                if((m+n)%2 == 0) {
                    return (Math.max(l1, l2) + Math.min(r1, r2))/2;
                }
                return Math.min(r1, r2);
            }
            else if(l2 > r1) {
                l = partX+1;
            } else {
                h = partX-1;
            }
        }
        return 0.0;
    }
}