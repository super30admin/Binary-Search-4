import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Arrays;

public class IntersectionOfTwoArraysTwo {
    public int[] intersect(int[] nums1, int[] nums2) {
        return intersectUsingHashMap(nums1, nums2);
        // return intersectUsingTwoPointers(nums1, nums2);
        // return intersectUsingBinarySearch(nums1, nums2);
    }

    // TC: O(m log n) where m is length of nums1, n is length of nums2
    // SC: O(Math.min(m, n)) where m is length of nums1, n is length of nums2
    private int[] intersectUsingBinarySearch(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> resList = new ArrayList<>();
        int left = 0, right = n1 - 1;
        for (int i = 0; i < nums2.length; i++) {
            int target = nums2[i];
            int index = binarySearch(nums1, left, right, target);
            if (index != -1) {
                resList.add(target);
                left = index + 1;
            }
        }
        int[] res = new int[resList.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = resList.get(i);
        }
        return res;
    }
    private int binarySearch(int[] arr, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left == arr.length || arr[left] != target ? -1 : left;
    }

    // TC: O(m + n) where m is length of nums1, n is length of nums2
    // SC: O(Math.min(m, n)) where m is length of nums1, n is length of nums2
    private int[] intersectUsingTwoPointers(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int p1 = 0, p2 = 0;
        List<Integer> resList = new ArrayList<>();
        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] == nums2[p2]) {
                resList.add(nums1[p1]);
                p1++;
                p2++;
            } else if (nums1[p1] < nums2[p2]) {
                p1++;
            } else {
                p2++;
            }
        }
        int[] res = new int[resList.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = resList.get(i);
        }
        return res;
    }

    // TC: O(m + n) where m is length of nums1, n is length of nums2
    // SC: O(Math.min(m, n)) where m is length of nums1, n is length of nums2
    private int[] intersectUsingHashMap(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        if (n1 > n2) return intersectUsingHashMap(nums2, nums1);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
        }
        List<Integer> resList = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i])) {
                resList.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i]) - 1);
                map.remove(nums2[i], 0);
            }
        }
        int[] res = new int[resList.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = resList.get(i);
        }
        return res;
    }
}
