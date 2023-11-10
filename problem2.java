//T.C-O(log(min(m,n)))
//S.C-O(1)
//passed all the test cases
// the approach is to partition the selected elements from both the arrays s.t the  no of elements are m+n.
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if (n1 > n2) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int low = 0, high = n1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int xpart = mid;
            int ypart = ((n1 + n2) / 2) - xpart;
            int l1 = xpart == 0 ? Integer.MIN_VALUE : nums1[xpart - 1];
            int r1 = xpart == n1 ? Integer.MAX_VALUE : nums1[xpart];
            int l2 = ypart == 0 ? Integer.MIN_VALUE : nums2[ypart - 1];
            int r2 = ypart == n2 ? Integer.MAX_VALUE : nums2[ypart];
            if (l1 <= r2 && l2 <= r1) {
                if ((n1 + n2) % 2 == 0) {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                } else {
                    return Math.min(r1, r2);
                }
            } else if (l1 > r2) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return 0.0;
    }
}
