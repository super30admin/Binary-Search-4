// Approach: Do binary search on partitions not the indices, compare L1 with R2 and L2 with R1
//  When correct partition is found, calculate and return median for odd or even no. of total numbers cases as required
// Time: O(log(n1)) since we only perform binary search on smaller array
// Space: O(1)

class Median_of_two_sorted_arrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if (nums1.length == 0 && nums2.length == 0) return 0.00;
        int n1 = nums1.length, n2 = nums2.length;
        if (n1 > n2) return findMedianSortedArrays(nums2, nums1);
        int low = 0, high = n1;

        while (low <= high) {
            int partX = low + (high-low) / 2;
            int partY = (n1 + n2)/2 - partX;
            double L1 = partX == 0 ? Integer.MIN_VALUE : nums1[partX - 1];
            double R1 = partX == n1 ? Integer.MAX_VALUE : nums1[partX];
            double L2 = partY == 0 ? Integer.MIN_VALUE : nums2[partY - 1];
            double R2 = partY == n2 ? Integer.MAX_VALUE : nums2[partY];

            if (L1 <= R2 && L2 <= R1) {
                // found correct partition, find medain now ->
                if ((n1+n2) % 2 == 0) {
                    // even no. of total elements
                    return (Math.min(R1,R2) + Math.max(L1,L2)) / 2;
                }
                else {
                    return Math.min(R1, R2);
                }
            }
            else if (L1 > R2) {
                high = partX - 1;
            }
            else {
                low = partX + 1;
            }
        }
        return 10.10;
    }
}
