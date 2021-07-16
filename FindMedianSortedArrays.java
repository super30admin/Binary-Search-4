/**
 * @author Vishal Puri
 * // Time Complexity : O(logn)
 * // Space Complexity : O(1)
 * // Did this code successfully run on Leetcode : Yes
 * // Any problem you faced while coding this :
 */

public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) return 0.0;
        if (nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);
        if (nums1.length == 0) {
            if (nums2.length == 1)
                return nums2[0];
            else
                return nums2.length % 2 == 0 ? (double) (nums2[nums2.length / 2 - 1] + nums2[nums2.length / 2]) / 2 : (double) nums2[nums2.length / 2];
        }
        //double L1=0, L2=0, R1=0, R2=0;
        int n = nums1.length + nums2.length;
        int low = 0, high = nums1.length;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            System.out.println(mid);
            double L1 = mid == 0 ? Integer.MIN_VALUE : nums1[mid - 1];
            double R1 = mid == nums1.length ? Integer.MAX_VALUE : nums1[mid];
            double L2 = n / 2 - mid == 0 ? Integer.MIN_VALUE : nums2[n / 2 - mid - 1];
            double R2 = n / 2 - mid == nums2.length ? Integer.MAX_VALUE : nums2[n / 2 - mid];
            System.out.println(L1 + " " + L2 + " " + R1 + " " + R2);
            if (L1 < R2 && L2 < R1) {
                if (n % 2 == 0) {
                    return (Math.max(L1, L2) + Math.min(R1, R2)) / 2;
                } else {
                    System.out.println("test" + L2 + " " + R1);
                    return Math.min(R1, R2);
                }
            } else if (L2 > R1)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return 1.00;
    }
}