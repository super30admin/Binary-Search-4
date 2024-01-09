
// Time complexity : m*(log(n)), given that if both the arrays are sorted
// Space complexity : O(1)
import java.util.*;

public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        int[] nums1 = { 4, 9, 5 };
        int[] nums2 = { 9, 4, 9, 8, 4 };
        int[] result = intersect(nums1, nums2);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n)
            return intersect(nums2, nums1);
        ArrayList<Integer> result = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int low = 0;
        int high = n - 1;
        for (int i = 0; i < m; i++) {
            int target = nums1[i];
            int bsIdx = binarySearch(nums2, low, high, target);
            if (bsIdx != -1) {
                result.add(target);
                low = bsIdx + 1;
            }
        }
        return result.stream().mapToInt(k -> k).toArray();
    }

    private static int binarySearch(int[] nums2, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums2[mid] == target) {
                if (mid == low || nums2[mid] != nums2[mid - 1]) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else if (nums2[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}