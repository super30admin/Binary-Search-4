import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Using Pointers
// TC: O(n log n) + O(m log m)
// SC: O(n)

// Using Binary search for locating the intersecting element
// TC: O(m log n)
// SC: O(n)
public class IntersectionofTwoArraysII {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersect(new int[] { 1, 2, 2, 1 }, new int[] { 2, 2 }))); // [2,2]
        System.out.println(Arrays.toString(intersect(new int[] { 4, 9, 5 }, new int[] { 9, 4, 9, 8, 4 }))); // [4,9]

        System.out.println(Arrays.toString(intersectUsingBS(new int[] { 1, 2, 2, 1 }, new int[] { 2, 2 }))); // [2,2]
        System.out.println(Arrays.toString(intersectUsingBS(new int[] { 4, 9, 5 }, new int[] { 9, 4, 9, 8, 4 }))); // [4,9]
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0)
            return new int[] {};
        int p1 = 0;
        int p2 = 0;
        if (nums1.length > nums2.length)
            intersect(nums2, nums1);
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int m = nums1.length;
        int n = nums2.length;
        List<Integer> list = new ArrayList<>();
        while (p1 < m && p2 < n) {
            if (nums1[p1] > nums2[p2]) {
                p2++;
            } else if (nums1[p1] < nums2[p2]) {
                p1++;
            } else {
                list.add(nums1[p1]);
                p1++;
                p2++;
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    private static int[] intersectUsingBS(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0)
            return new int[] {};
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) {
            return intersectUsingBS(nums2, nums1);
        }
        int low = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int returning = binarySearch(nums2, low, n - 1, nums1[i]);
            if (returning != -1) {
                list.add(nums1[i]);
                low = returning + 1;
            }
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;

    }

    private static int binarySearch(int[] nums, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                if (low == mid || nums[mid] != target) {
                    return mid;
                }
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

}