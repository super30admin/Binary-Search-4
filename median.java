// Time: O(log min(m, n)), Space: O(1)

/* 
    1. Perform binary search on the smaller array to find a partition that splits both arrays into two halves.
    2. Adjust the partition until the largest on the left ≤ smallest on the right.
    3. Compute median from max(left) and min(right) based on even or odd total length.
*/

public class median {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if (nums2.length < nums1.length) {
            return findMedianSortedArrays(nums2, nums1); // Ensure binary search is on the smaller array
        }

        int l = 0;
        int r = nums1.length;
        int mid = (nums1.length + nums2.length) / 2;

        while (true) {
            int li = (l + r) / 2;          
            int ri = mid - li;          

            int a = (li - 1 >= 0) ? nums1[li - 1] : Integer.MIN_VALUE; 
            int b = (li < nums1.length) ? nums1[li] : Integer.MAX_VALUE; 
            int c = (ri - 1 >= 0) ? nums2[ri - 1] : Integer.MIN_VALUE;
            int d = (ri < nums2.length) ? nums2[ri] : Integer.MAX_VALUE; 

            if (a <= d && c <= b) {
                if ((nums1.length + nums2.length) % 2 == 0) {
                    return ((double) Math.max(a, c) + (double) Math.min(b, d)) / 2; 
                } else {
                    return (double) Math.min(b, d);
                }
            } else if (a > d) {
                r = li - 1; 
            } else {
                l = li + 1;
            }
        }
    }
}