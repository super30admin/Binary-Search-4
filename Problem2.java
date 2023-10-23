// Time Complexity : O(log(min(m, n))) where n is the size of nums1 and m is the size of nums2
// Space Complexity : O(1) constant space as we did not use any extra space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Problem2 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1 == null && nums2 == null){
            return -1.0;
        }

        if(nums2.length < nums1.length){
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;

        int low = 0;
        int high = m;

        while(low <= high){
            int partX = low + (high - low) / 2;
            int partY = (m + n) / 2 - partX;
            double l1 = partX == 0 ? Integer.MIN_VALUE : nums1[partX - 1];
            double l2 = partY == 0 ? Integer.MIN_VALUE : nums2[partY - 1];
            double r1 = partX == m ? Integer.MAX_VALUE : nums1[partX];
            double r2 = partY == n ? Integer.MAX_VALUE : nums2[partY];

            if(l1 <= r2 && l2 <= r1){
                if((m + n) % 2 == 0){
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                }
                return Math.min(r1, r2);

            }else if(l2 > r1){
                low = partX + 1;
            }else if(l1 > r2){
                high = partX - 1;
            }
        }

        return 0.0;
    }
}
