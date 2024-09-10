// Time Complexity: O(log(min(m, n)))
// Space Complexity: O(1)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Ensure that nums1 is the smaller array to minimize binary search complexity
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int m = nums1.length;
        int n = nums2.length;
        int low = 0, high = m;
        
        while (low <= high) {
            int partition1 = (low + high) / 2;
            int partition2 = (m + n + 1) / 2 - partition1;
            
            // If partition1 is 0, it means nothing is left from nums1, so use Integer.MIN_VALUE
            // If partition1 is m, it means nums1 is entirely on the left, so use Integer.MAX_VALUE
            int maxLeft1 = (partition1 == 0) ? Integer.MIN_VALUE : nums1[partition1 - 1];
            int minRight1 = (partition1 == m) ? Integer.MAX_VALUE : nums1[partition1];
            
            int maxLeft2 = (partition2 == 0) ? Integer.MIN_VALUE : nums2[partition2 - 1];
            int minRight2 = (partition2 == n) ? Integer.MAX_VALUE : nums2[partition2];
            
            // Check if we have found the correct partition
            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                // If the combined array size is even, return the average of the middle two numbers
                if ((m + n) % 2 == 0) {
                    return ((double) Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2;
                } else {
                    // If the combined array size is odd, return the max of the left halves
                    return (double) Math.max(maxLeft1, maxLeft2);
                }
            } else if (maxLeft1 > minRight2) {
                // We are too far to the right in nums1, move left
                high = partition1 - 1;
            } else {
                // We are too far to the left in nums1, move right
                low = partition1 + 1;
            }
        }
        
        // If we reach here, something is wrong with the input (shouldn't happen for valid inputs)
        throw new IllegalArgumentException("Input arrays are not sorted or valid.");
    
    }
}
