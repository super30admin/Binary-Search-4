import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Time Complexity: O(mlogm) + O(nlogn)
 * Space Complexity: O(1)
 * Did this code successfully run on Leetcode: Yes
 * Any problem you faced while coding this: None

 * Approach:
 * 1. Sort the given lists
 * 2. Take one element from the array and look for it in another array
 * 3. Add the result to result array
 */

public class IntersectionOfTwoArrays2 {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[]{0, 0};
        }
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int m = nums1.length;
        int n = nums2.length;
        int low = 0;
        List<Integer> result = new ArrayList<>();
        if (m < n) {
            for (int num: nums2) {
                int index = binarySearch(nums1, low, m - 1, num);
                if (index != -1) {
                    result.add(nums1[index]);
                    low = index + 1;
                }
            }
        } else {
            for (int num: nums1) {
                int index = binarySearch(nums2, low, n - 1, num);
                if (index != -1) {
                    result.add(nums2[index]);
                    low = index + 1;
                }
            }
        }
        
        int[] finalResult = new int[result.size()];
        int i = 0;
        for (int val: result) {
            finalResult[i++] = val;
        }

        return finalResult;
    }

    private int binarySearch(int[] num, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low)/2;

            if (num[mid] == target) {
                if (mid == low || num[mid - 1] != target) {
                    return mid;
                } 
                high = mid - 1;
            } else if (num[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        // Your code here
    }
}