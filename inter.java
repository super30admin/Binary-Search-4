import java.util.*;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new LinkedList<>();
        int index = 0;
        for (int i = 0; i < nums1.length; i++) {
            int loc = binarySearch(nums2, index, nums1[i]);
            if (loc != -1) {
                list.add(nums1[i]);
                index = loc + 1;
            }
        }

        int[] res = new int[list.size()];
        int i = 0;
        for (int element : list) {
            res[i++] = element;
        }
        return res;
    }

    public int binarySearch(int[] nums, int index, int target) {
        int left = index, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                if (mid == left || nums[mid - 1] != target)
                    return mid;
                else
                    right = mid - 1;
            } else if (nums[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums1 = { 1, 2, 2, 1 };
        int[] nums2 = { 2, 2 };
        int[] result = s.intersect(nums1, nums2);
        for (int i : result) {
            System.out.println(i);
        }
    }
}