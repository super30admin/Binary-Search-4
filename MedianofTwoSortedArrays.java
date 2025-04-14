// TC: O(log (m + n)) the computation is only done on the  half length elements using 
// low and high. and this is boundary is moved left or right based on the criteria.
// SC: O(n) No extra space is used.

// Runs successfully on Leetcode.
// instead of traversing all the numbers, a variation of binary search logic is used here. 
public class MedianofTwoSortedArrays {
    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[] { 1, 3 }, new int[] { 2 }));
        System.out.println(findMedianSortedArrays(new int[] { 1, 2 }, new int[] { 3, 4 }));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null)
            return 0.0;
        int m = nums1.length;
        int n = nums2.length;
        if (m > n)
            return findMedianSortedArrays(nums2, nums1);
        int low = 0;
        int high = m;
        while (low <= high) {
            int partX = low + (high - low) / 2;
            int partY = (m + n) / 2 - partX;
            double l1 = partX == 0 ? Integer.MIN_VALUE : nums1[partX - 1];
            double r1 = partX == m ? Integer.MAX_VALUE : nums1[partX];
            double l2 = partY == 0 ? Integer.MIN_VALUE : nums2[partY - 1];
            double r2 = partY == n ? Integer.MAX_VALUE : nums2[partY];
            if (l1 <= r2 && l2 <= r1) {
                if ((m + n) % 2 == 0)
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                return Math.min(r1, r2);
            } else if (l1 > r2) {
                high = partX - 1;
            } else if (l2 > r1) {
                low = partX + 1;
            }
        }
        return 0.0;
    }
}
