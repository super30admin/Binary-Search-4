import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class intersectionOfTwoArrays {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[] {};
        }

        int m = nums1.length;
        int n = nums2.length;

        // Ensure we always binary search on the larger array
        if (m > n) {
            return intersect(nums2, nums1);
        }

        List<Integer> result = new ArrayList<>();

        // Sort both arrays
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int low = 0; // Start searching from index 0
        for (int i = 0; i < m; i++) {
            int bSearch = binarySearch(nums2, low, n - 1, nums1[i]);
            if (bSearch != -1) {
                result.add(nums1[i]);
                low = bSearch + 1; // Move forward to prevent duplicates
            }
        }

        // Convert list to array
        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }
        return ans;
    }

    // Binary search to find the first occurrence of target in nums2
    public int binarySearch(int[] nums2, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums2[mid] == target) {
                // Find the first occurrence of target
                if (mid == low || nums2[mid - 1] != target) {
                    return mid;  // Return index instead of value
                }
                high = mid - 1;
            }
            else if (nums2[mid] < target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return -1;
    }
}