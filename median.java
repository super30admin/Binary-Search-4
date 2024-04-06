import java.util.*;

class Solution {
    // Tc: O(log(m+n)) Sc: O(1)
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int n1 = nums1.length, n2 = nums2.length;

        if (n1 > n2)
            return findMedianSortedArrays(nums2, nums1);

        int n = n1 + n2;

        int left = (n1 + n2 + 1) / 2;
        int low = 0, high = n1;
        while (low <= high) {
            int mid1 = (low + high) >> 1;
            int mid2 = left - mid1;

            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE, r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;

            if (mid1 < n1)
                r1 = nums1[mid1];
            if (mid2 < n2)
                r2 = nums2[mid2];
            if (mid1 - 1 >= 0)
                l1 = nums1[mid1 - 1];
            if (mid2 - 1 >= 0)
                l2 = nums2[mid2 - 1];

            if (l1 <= r2 && l2 <= r1) {
                if (n % 2 == 1)
                    return Math.max(l1, l2);
                else
                    return ((double) (Math.max(l1, l2) + Math.min(r1, r2))) / 2.0;
            } else if (l1 > r2) {

                high = mid1 - 1;
            } else {

                low = mid1 + 1;
            }
        }

        return 0;

    }
}

/*
 * class Solution {
 * public double findMedianSortedArrays(int[] nums1, int[] nums2) {
 * // Tc:O(M+N) Sc: O(M+N)
 * ArrayList<Integer> res = new ArrayList<>();
 * int p1 = 0;
 * int p2 = 0;
 * 
 * while (p1 < nums1.length && p2 < nums2.length) {
 * if (nums1[p1] < nums2[p2]) {
 * res.add(nums1[p1]);
 * p1++;
 * } else {
 * res.add(nums2[p2]);
 * p2++;
 * }
 * }
 * 
 * while (p1 < nums1.length) {
 * res.add(nums1[p1]);
 * p1++;
 * }
 * 
 * while (p2 < nums2.length) {
 * res.add(nums2[p2]);
 * p2++;
 * }
 * 
 * int size = res.size();
 * if (size % 2 == 0)
 * return (res.get(size / 2 - 1) + res.get(size / 2)) / 2.0;
 * else
 * return res.get(size / 2);
 * }
 * }
 * 
 */