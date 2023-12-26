// Time Complexity : O(log(min(n1,n2)));
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

public class Problem2 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        if (n1 > n2) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int low = 0;
        int high = n1;

        while (low <= high) {
            int partX = low + (high - low) / 2;
            int partY = (n1 + n2) / 2 - partX;

            double L1 = partX == 0 ? Integer.MIN_VALUE : nums1[partX - 1];
            double R1 = partX == n1 ? Integer.MAX_VALUE : nums1[partX];
            double L2 = partY == 0 ? Integer.MIN_VALUE : nums2[partY - 1];
            double R2 = partY == n2 ? Integer.MAX_VALUE : nums2[partY];

            if (L1 <= R2 && L2 <= R1) {
                if ((n1 + n2) % 2 == 0) {
                    return (Math.max(L1, L2) + Math.min(R1, R2)) / 2;
                } else {
                    return Math.min(R1, R2);
                }

            } else if (L1 > R2) {
                high = partX - 1;
            } else {
                low = partX + 1;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        Problem2 solution = new Problem2();

        
        int[] nums1 = { 1, 3 };
        int[] nums2 = { 2 };
        double median = solution.findMedianSortedArrays(nums1, nums2);

        System.out.println("Median of sorted arrays: " + median);
    }
}
