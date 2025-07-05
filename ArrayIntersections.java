import java.util.*;

// Time complexity: O(m log m + n log n + m log n) where m is the length of nums1 and n is the length of nums2.
// Space complexity: O(m + n) for storing the result.
public class ArrayIntersections {
    public int[] intersect(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        Arrays.sort(nums1); // mlogm
        Arrays.sort(nums2);
        int low = 0, high = n2 - 1;

        List<Integer> result = new ArrayList<>();
        if (n2 < n1) {
            return intersect(nums2, nums1);
        }

        for (int i = 0; i < n1; i++) { // mlogn
            int occurence = binarySearchFirst(nums2, low, high, nums1[i]);
            if (occurence == -1)
                continue;
            result.add(nums1[i]);
            low = occurence + 1;
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private int binarySearchFirst(int[] nums, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                if (mid == low || nums[mid] > nums[mid - 1]) // it is first index
                    return mid;
                else
                    high = mid - 1; // keep moving left
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

}
