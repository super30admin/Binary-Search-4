class Solution {
    // here we use binary search to solve this problem
    // Time complexity: O(logn)
    // Space complexity: O(logn)
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int sum = m + n;
        if (sum % 2 == 0) {
            return (findKth(nums1, 0, nums2, 0, sum / 2) + findKth(nums1, 0, nums2, 0, sum / 2 + 1)) / 2.0;
        } else {
            return findKth(nums1, 0, nums2, 0, sum / 2 + 1) * 1.0;
        }
    }
    
    private int findKth(int[] a, int startA, int[] b, int startB, int k) {
        if (startA >= a.length) {
            return b[startB + k - 1];
        }
        if (startB >= b.length) {
            return a[startA + k - 1];
        }
        if (k == 1) {
            return Math.min(a[startA], b[startB]);
        }
        // start to throw away k/2 length array in either a or b
        int midA = (startA + k / 2 - 1 >= a.length) ? Integer.MAX_VALUE : a[startA + k / 2 - 1];
        int midB = (startB + k / 2 - 1 >= b.length) ? Integer.MAX_VALUE : b[startB + k / 2 - 1];
        if (midA > midB) {
            return findKth(a, startA, b, startB + k / 2, k - k / 2);
        } else {
            return findKth(a, startA + k / 2, b, startB, k - k / 2);
        }
    }
}

