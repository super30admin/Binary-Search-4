import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Time complexity: O(mlogn) + O(nlogn)+O(mlogm)
//space complexity: O(1)

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[] {};
        }
        int n1 = nums1.length;
        int n2 = nums2.length;
        if (n2 < n1) {
            return intersect(nums2, nums1);
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> result = new ArrayList<>();
        int low = 0;
        for (int i = 0; i < nums1.length; i++) {
            int bIndex = binarySearch(nums2, low, n2 - 1, nums1[i]);
            if (bIndex != -1) {
                result.add(nums1[i]);
                low = bIndex + 1;
            }
        }

        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;

    }

    public int binarySearch(int[] nums, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                if (mid == low || nums[mid - 1] < nums[mid]) { // checking if its the 1st occurence or not
                    return mid;
                }
                high = mid - 1; // if not 1st occurence, then move left to find the first occurence
            } else if (target > nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}