public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Ensure nums1 is the smaller array to minimize binary search range
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int m = nums1.length;
        int n = nums2.length;
        int low = 0, high = m;
        
        while (low <= high) {
            // Partitioning nums1 and nums2
            int partition1 = (low + high) / 2;
            int partition2 = (m + n + 1) / 2 - partition1;
            
            // Handling edge cases with MIN and MAX values
            int maxLeft1 = (partition1 == 0) ? Integer.MIN_VALUE : nums1[partition1 - 1];
            int minRight1 = (partition1 == m) ? Integer.MAX_VALUE : nums1[partition1];
            
            int maxLeft2 = (partition2 == 0) ? Integer.MIN_VALUE : nums2[partition2 - 1];
            int minRight2 = (partition2 == n) ? Integer.MAX_VALUE : nums2[partition2];
            
            // Check if valid partition is achieved
            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                // If total length is even
                if ((m + n) % 2 == 0) {
                    return ((double)Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2;
                } else { // If total length is odd
                    return (double)Math.max(maxLeft1, maxLeft2);
                }
            } else if (maxLeft1 > minRight2) {
                // Move partition1 to the left
                high = partition1 - 1;
            } else {
                // Move partition1 to the right
                low = partition1 + 1;
            }
        }
        
        // If we reach here, input arrays are not sorted
        throw new IllegalArgumentException("Input arrays are not sorted.");
    }
}

/*
Time Complexity (TC):
- Binary search on the smaller array: O(log(min(m, n)))
- Where m = nums1.length and n = nums2.length
- Finding median with partitioning is O(1)
- Overall TC: O(log(min(m, n)))

Space Complexity (SC):
- Only a few variables are used, independent of input size
- No additional data structures that scale with input size
- Overall SC: O(1)
*/
