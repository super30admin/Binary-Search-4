//  Time Complexity: O(n*log(n)) + n*log(m)
//  Space Complexity: O(result.length)

import java.util.*;

public class IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> list = new ArrayList<>();

        int low = 0;
        int high = nums2.length - 1;

        for (int num : nums1) {
            int bIndex = modifiedBinarySearch(nums2, low, high, num);
            if (bIndex != -1) {
                list.add(num);
                low = bIndex + 1;
            }
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; ++i) {
            result[i] = list.get(i);
        }

        return result;
    }

    private int modifiedBinarySearch(int[] ar, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (target == ar[mid]) {
                //  keep moving left and find first occurrence
                if (mid > low && ar[mid] == ar[mid - 1]) {
                    high = mid - 1;
                }
                else {
                    return mid;
                }
            }
            else if (target > ar[mid]) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return -1;
    }
}
