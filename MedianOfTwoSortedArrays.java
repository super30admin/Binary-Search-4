// Time Complexity: O(log(min(m,n))
// Space Complexity: O(1)
// Did this code successfully run on Leetcode: yes
// Any problem you faced while coding this: no
// Your code here along with comments explaining your approach: as commented

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int n1 = nums1.length, n2 = nums2.length;

        // make sure nums1 has lesser elements than nums2
        if (n1 > n2)
            return findMedianSortedArrays(nums2, nums1);

        // number of elements that can be taken from nums1
        int low = 0, high = n1;
        double median = 0.0;

        boolean even = false;
        if ((n1 + n2) % 2 == 0)
            even = true;

        while (low <= high) {

            int par1 = (low + high) / 2;
            int par2 = (n1 + n2 + 1) / 2 - par1; // want to make the first half always 1 more than 2nd half
            // handles both even and odd case

            // calculate l1,l2,r1,r2
            int l1 = (par1 == 0) ? Integer.MIN_VALUE : nums1[par1 - 1];
            int r1 = (par1 == n1) ? Integer.MAX_VALUE : nums1[par1];

            int l2 = (par2 == 0) ? Integer.MIN_VALUE : nums2[par2 - 1];
            int r2 = (par2 == n2) ? Integer.MAX_VALUE : nums2[par2];

            // compare l1,l2,r1,r2 and compute the median

            // median found
            if (l1 <= r2 && l2 <= r1) {
                if (even)
                    median = (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                else
                    median = Math.max(l1, l2);
                break;
            } else if (l1 > r2) {
                high = par1 - 1; // dec l1,inc r2(go left)
            } else if (l2 > r1) {
                low = par1 + 1;
            }
        }
        return median;
    }
}
