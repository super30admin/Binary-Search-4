// Time Complexity: O(m log m + n.m)
// Space Complexity : O(m + min (n,m)) 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class IntersectionOfTwoArrays {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums2); // Sort nums2 for binary search
        List<Integer> result = new ArrayList<>();
        List<Integer> sortedNums2 = new ArrayList<>();

        // Convert nums2 to a list for easy removal of elements
        for (int num : nums2) {
            sortedNums2.add(num);
        }

        // Perform binary search for each element in nums1
        for (int num : nums1) {
            int index = binarySearch(sortedNums2, num);
            if (index != -1) {
                result.add(num);
                sortedNums2.remove(index); // Remove the used element
            }
        }

        // Convert the result list to an array
        int[] intersection = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            intersection[i] = result.get(i);
        }
        return intersection;
    }

    // Helper function for binary search
    private static int binarySearch(List<Integer> sortedNums, int target) {
        int left = 0, right = sortedNums.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (sortedNums.get(mid) == target) {
                // Check for the first occurrence of the target
                if (mid == left || !sortedNums.get(mid - 1).equals(target)) {
                    return mid;
                } else {
                    right = mid - 1;
                }
            } else if (sortedNums.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1; // Target not found
    }

    public static void main(String[] args) {
        IntersectionOfTwoArrays solution = new IntersectionOfTwoArrays();

        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};

        int[] result = solution.intersect(nums1, nums2);
        System.out.println(Arrays.toString(result));
    }
}
