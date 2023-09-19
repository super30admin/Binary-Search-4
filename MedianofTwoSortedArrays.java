//Time Complexity: O(log(min(m, n)))
//Space Complexity: O(1)

public class MedianofTwoSortedArrays {

    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {

            // num1 = [1,2];
            // num2 = [2];

            if (nums1.length == 0 || nums2.length == 0)
                return 0;
            int m = nums1.length;
            int n = nums2.length;
            if (m > n)
                return findMedianSortedArrays(nums2, nums1);
            int low = 0;
            int high = m;
            while (low <= high) {
                int partX = low + (high - low) / 2;
                int partY = (m + n) / 2 - partX;
                double L1 = partX == 0 ? Integer.MIN_VALUE : nums1[partX - 1];
                double L2 = partY == 0 ? Integer.MIN_VALUE : nums2[partY - 1];
                double R1 = partX == m ? Integer.MAX_VALUE : nums1[partX];
                double R2 = partY == n ? Integer.MAX_VALUE : nums2[partY];

                if (L1 <= R2 && L2 <= R1) {

                    if ((m + n) % 2 == 0) {
                        return Math.max(L1, L2) + Math.min(R1, R2) / 2;
                    } else {
                        return Math.min(R1, R2);
                    }
                } else if (L1 > R2) {
                    low = partX + 1;
                } else {
                    high = partX - 1;
                }

            }

            return 0;
        }

    }
}