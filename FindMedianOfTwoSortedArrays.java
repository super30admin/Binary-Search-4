package BinarySearch4;
// Time Complexity : O(log(Min(m, n)))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

public class FindMedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length)
            return findMedianSortedArrays(nums2, nums1);
        int total = nums1.length + nums2.length;
        int low = 0;
        int high = nums1.length;

        while (low <= high){
            int partX = low + ((high-low) / 2);
            int partY = total / 2 - partX;
            double L1 = (partX == 0)? Integer.MIN_VALUE : nums1[partX-1];
            double R1 = (partX == nums1.length)? Integer.MAX_VALUE : nums1[partX];
            double L2 = (partY == 0)? Integer.MIN_VALUE : nums2[partY-1];
            double R2 = (partY == nums2.length)? Integer.MAX_VALUE : nums2[partY];
            // System.out.println(L1+" "+L2+" "+R1+" "+R2);
            if(L1 <= R2 && L2 <= R1){
                if(total % 2 == 0){
                    return (Math.max(L1, L2) + Math.min(R1, R2)) / 2.0;
                } else {
                    return Math.min(R1,R2);
                }
            } else if (L1 > R2){
                high = partX - 1;
            } else {
                low = partX + 1;
            }

        }
        return 1.0d;

    }
}
