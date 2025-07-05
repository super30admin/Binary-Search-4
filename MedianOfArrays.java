
// Time Complexity: O(log(min(m, n))) where m is the length of nums1 and n is the length of nums2.
// Space Complexity: O(1) as we are using only a constant amount of space.
public class MedianOfArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Ensure nums1 is the smaller array
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int total = m + n;
        int half = total / 2;

        int left = 0, right = m;
        while (true) {
            int i = (left + right) / 2; // Partition index for nums1
            int j = half - i; // Partition index for nums2

            int Aleft = (i > 0) ? nums1[i - 1] : Integer.MIN_VALUE;
            int Aright = (i < m) ? nums1[i] : Integer.MAX_VALUE;

            int Bleft = (j > 0) ? nums2[j - 1] : Integer.MIN_VALUE;
            int Bright = (j < n) ? nums2[j] : Integer.MAX_VALUE;

            // Partition is correct
            if (Aleft <= Bright && Bleft <= Aright) {
                // Odd total length
                if (total % 2 == 1) {
                    return Math.min(Aright, Bright);
                }
                // Even total length
                return (Math.max(Aleft, Bleft) + Math.min(Aright, Bright)) / 2.0;
            }
            // Move partition left in nums1
            else if (Aleft > Bright) {
                right = i - 1;
            }
            // Move partition right in nums1
            else {
                left = i + 1;
            }
        }
    }
}
