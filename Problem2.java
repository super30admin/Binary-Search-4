//Time = O(log(m+n))
//Space = O(1)

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        
        // Ensure nums1 is the smaller array
        if (m > n) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
            int tmp = m;
            m = n;
            n = tmp;
        }
        
        // Initialize binary search range and half-length
        int imin = 0, imax = m, halfLen = (m + n + 1) / 2;
        
        // Perform binary search to find median
        while (imin <= imax) {
            int i = (imin + imax) / 2;  // Choose index in nums1
            int j = halfLen - i;        // Corresponding index in nums2
            
            // Check if i is too small, adjust imin accordingly
            if (i < imax && nums2[j-1] > nums1[i]) {
                imin = i + 1;
            }
            // Check if i is too big, adjust imax accordingly
            else if (i > imin && nums1[i-1] > nums2[j]) {
                imax = i - 1;
            }
            // i is perfect, calculate median value
            else {
                int maxLeft = 0;
                // Determine max value on left side of median
                if (i == 0) {
                    maxLeft = nums2[j-1];
                }
                else if (j == 0) {
                    maxLeft = nums1[i-1];
                }
                else {
                    maxLeft = Math.max(nums1[i-1], nums2[j-1]);
                }
                // If combined length is odd, return maxLeft as median
                if ((m + n) % 2 == 1) {
                    return maxLeft;
                }
                
                int minRight = 0;
                // Determine min value on right side of median
                if (i == m) {
                    minRight = nums2[j];
                }
                else if (j == n) {
                    minRight = nums1[i];
                }
                else {
                    minRight = Math.min(nums1[i], nums2[j]);
                }
                // If combined length is even, return average of maxLeft and minRight as median
                return (maxLeft + minRight) / 2.0;
            }
        }
        
        // If median is not found, return 0.0
        return 0.0;
    }
}
