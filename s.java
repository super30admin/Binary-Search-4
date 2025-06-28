import java.util.*;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> result = new ArrayList<>();
        int low1 = 0;
        int low2 = 0;
        while (low1 < nums1.length && low2 < nums2.length) {
            if (nums1[low1] == nums2[low2]) {
                result.add(nums1[low1]);
                low1++;
                low2++;
            } else if (nums1[low1] > nums2[low2]) {
                low2++;
            } else {
                low1++;
            }
        }

        int[] arrayresult = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            arrayresult[i] = result.get(i);
        }
        return arrayresult;
    }

    // Problem 2: Median of Two Sorted Arrays
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Ensure nums1 is the smaller array
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int x = nums1.length;
        int y = nums2.length;
        int low = 0;
        int high = x;

        while (low <= high) {
            int partitionX = (low + high) / 2;
            int partitionY = (x + y + 1) / 2 - partitionX;

            // If partitionX is 0 it means nothing is there on left side. Use -inf for
            // maxLeftX
            // If partitionX is length of input then there is nothing on right side. Use
            // +inf for minRightX
            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minRightX = (partitionX == x) ? Integer.MAX_VALUE : nums1[partitionX];

            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightY = (partitionY == y) ? Integer.MAX_VALUE : nums2[partitionY];

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                // We have partitioned array at correct place
                if ((x + y) % 2 == 0) {
                    return ((double) Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
                } else {
                    return Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) {
                // We are too far on right side for partitionX. Go on left side.
                high = partitionX - 1;
            } else {
                // We are too far on left side for partitionX. Go on right side.
                low = partitionX + 1;
            }
        }

        // Only we can come here is if input arrays were not sorted. Throw in that
        // scenario.
        throw new IllegalArgumentException("Input arrays are not sorted");
    }
}

// Test class to demonstrate the solutions
class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Problem 1: Intersection of Two Arrays II
        System.out.println("=== Problem 1: Intersection of Two Arrays II ===");
        int[] nums1_1 = { 1, 2, 2, 1 };
        int[] nums2_1 = { 2, 2 };
        int[] result1 = solution.intersect(nums1_1, nums2_1);
        System.out.print("Input: nums1 = [1,2,2,1], nums2 = [2,2]\nOutput: [");
        for (int i = 0; i < result1.length; i++) {
            System.out.print(result1[i]);
            if (i < result1.length - 1)
                System.out.print(",");
        }
        System.out.println("]");

        // Test Problem 2: Median of Two Sorted Arrays
        System.out.println("\n=== Problem 2: Median of Two Sorted Arrays ===");
        int[] nums1_2 = { 1, 3 };
        int[] nums2_2 = { 2 };
        double result2 = solution.findMedianSortedArrays(nums1_2, nums2_2);
        System.out.println("Input: nums1 = [1,3], nums2 = [2]");
        System.out.println("Output: " + result2);

        int[] nums1_3 = { 1, 2 };
        int[] nums2_3 = { 3, 4 };
        double result3 = solution.findMedianSortedArrays(nums1_3, nums2_3);
        System.out.println("Input: nums1 = [1,2], nums2 = [3,4]");
        System.out.println("Output: " + result3);
    }
}
