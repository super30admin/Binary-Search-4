import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//Time Complexity : O(MlogN)
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/**
 * Make the smaller array as 1st one. Then apply Binary Search on each element
 * of that array. Find the index of that num and then update the left index to
 * be passed to this BS with that index + 1. this way, we don't check the left
 * part of the array. return the fetched result.
 *
 */
class Solution {
	public int[] intersect(int[] nums1, int[] nums2) {
		if (nums1.length > nums2.length)
			return intersect(nums2, nums1);
		List<Integer> ans = new ArrayList<>();
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int leftIndex = 0;
		for (int num : nums1) {
			int index = binarySearch(nums2, num, leftIndex);
			if (index != -1) {
				ans.add(num);
				leftIndex = index + 1;
			}
		}
		int[] res = new int[ans.size()];
		for (int i = 0; i < ans.size(); i++)
			res[i] = ans.get(i);
		return res;
	}

	public int binarySearch(int[] nums, int target, int left) {
		int right = nums.length - 1;
		int ans = -1;
		while (left <= right) {
			int mid = left + (right - left) / 2;

			if (nums[mid] == target) {
				ans = mid;
				right = mid - 1;
			} else if (nums[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return ans;
	}
}