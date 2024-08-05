// TC - O(nlogn)
// SC-  O(1)

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Ensure nums1 is smaller or equal in length compared to nums2 for simplicity
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int n = nums1.length;
        int m = nums2.length;
        int low = 0;
        int high = n;
        
        while (low <= high) {
            int partX = low + (high - low) / 2; // Partition for nums1
            int partY = (n + m) / 2 - partX;   // Partition for nums2
            
            // Calculate left and right elements around the partitions
            int L1 = (partX == 0) ? Integer.MIN_VALUE : nums1[partX - 1];
            int R1 = (partX == n) ? Integer.MAX_VALUE : nums1[partX];
            int L2 = (partY == 0) ? Integer.MIN_VALUE : nums2[partY - 1];
            int R2 = (partY == m) ? Integer.MAX_VALUE : nums2[partY];
            
            // Check if partitions are in correct place
            if (L1 <= R2 && L2 <= R1) {
                // If total number of elements is even, return the average of middle elements
                if ((n + m) % 2 == 0) {
                    return (Math.max(L1, L2) + Math.min(R1, R2)) / 2.0;
                } else {
                    // Otherwise, return the smaller of the two middle elements
                    return Math.min(R1, R2) / 1.0;
                }
            } else if (L2 > R1) {
                // If partition of nums2 is too far right, move partition of nums1 to the right
                low = partX + 1;
            } else {
                // Otherwise, move partition of nums1 to the left
                high = partX - 1;
            }
        }
        
        // Default return value if no median is found
        return 1.0;
    }
}
