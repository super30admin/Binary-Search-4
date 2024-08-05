// TC - O(nlogm+mlogm)
//SC-  O(n)

class Solution {

    // Helper function to perform binary search to find the leftmost index of k in nums
    private int leftMostBS(int[] nums, int left, int k) {
        int right = nums.length - 1; // Initialize right boundary
        int result = -1; // Initialize result to -1 to signify not found

        // Perform binary search
        while (left <= right) {
            int mid = left + (right - left) / 2; // Calculate the middle index
            if (nums[mid] == k) {
                result = mid; // Update result to the current mid index
                right = mid - 1; // Continue searching in the left half to find the leftmost occurrence
            } else if (nums[mid] > k) {
                right = mid - 1; // Narrow search to the left half
            } else {
                left = mid + 1; // Narrow search to the right half
            }
        }
        return result; // Return the leftmost index of k, or -1 if not found
    }

    // Function to find the intersection of two arrays
    public int[] intersect(int[] nums1, int[] nums2) {
        // Ensure nums1 is the smaller array for optimization
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }

        // List to store the intersection results
        ArrayList<Integer> result = new ArrayList<>();
        
        // Sort both arrays
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int low = 0; // Initialize the starting index for binary search in nums2
        
        // Traverse through nums1 and find each element's index in nums2
        for (int i = 0; i < nums1.length; i++) {
            int elIdx = leftMostBS(nums2, low, nums1[i]); // Find the index of nums1[i] in nums2 starting from 'low'
            
            // If element is found, add it to the result and update low for the next search
            if (elIdx != -1) {
                result.add(nums1[i]);
                low = elIdx + 1; // Move 'low' to the right of the found index to prevent duplicate intersections
            }
        }

        // Convert the result list to an array
        int[] res = new int[result.size()];
        int i = 0;
        for (int j : result) {
            res[i++] = j;
        }

        // Return the final array containing the intersection of nums1 and nums2
        return res;
    }
}
