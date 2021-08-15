// Time Complexity : O(m + n), m -> Length of nums1, n -> Length of nums2
// Space Complexity : O(min(m, n))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArrayIntersection {
	/********************* Two Pointers *********************/
	// Time Complexity : O(mlogm + nlogn), m -> Length of nums1, n -> Length of
	// nums2
	// Space Complexity : O(1)
	// Did this code successfully run on Leetcode : Yes
	// Any problem you faced while coding this : No
	public int[] intersectTwoPointer(int[] nums1, int[] nums2) {
		if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
			return new int[0];
		}

		Arrays.sort(nums1);
		Arrays.sort(nums2);

		int i = 0;
		int j = 0;
		int k = 0;

		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] == nums2[j]) {
				nums1[k++] = nums2[j];
				i++;
				j++;
			} else if (nums1[i] < nums2[j]) {
				i++;
			} else {
				j++;
			}
		}

		return Arrays.copyOfRange(nums1, 0, k);
	}

	/********************* HashMap *********************/
	// Time Complexity : O(m + n), m -> Length of nums1, n -> Length of nums2
	// Space Complexity : O(min(m, n))
	// Did this code successfully run on Leetcode : Yes
	// Any problem you faced while coding this : No
	public int[] intersect(int[] nums1, int[] nums2) {
		if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
			return new int[0];
		}

		if (nums1.length > nums2.length) {
			return intersect(nums2, nums1);
		}

		Map<Integer, Integer> cntMap = new HashMap<Integer, Integer>();
		List<Integer> result = new ArrayList<Integer>();

		for (int num : nums1) {
			cntMap.put(num, cntMap.getOrDefault(num, 0) + 1);
		}

		for (int num : nums2) {
			if (cntMap.containsKey(num)) {
				result.add(num);
				cntMap.put(num, cntMap.get(num) - 1);
				if (cntMap.get(num) == 0) {
					cntMap.remove(num);
				}
			}
		}

		int[] res = new int[result.size()];
		for (int i = 0; i < result.size(); i++) {
			res[i] = result.get(i);
		}

		return res;
	}

	/********************* Binary Search *********************/
	// Time Complexity : O(mlog n), m -> Length of nums1 (smaller array), n -> Length of nums2 (larger array)
	// Space Complexity : O(m)
	// Did this code successfully run on Leetcode : Yes
	// Any problem you faced while coding this : No
	public int[] intersectBinarySearch(int[] nums1, int[] nums2) {
		if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
			return new int[0];
		}

		if (nums1.length > nums2.length) {
			return intersect(nums2, nums1);
		}

		Arrays.sort(nums1);
		Arrays.sort(nums2);

		int low = 0;
		int high = nums2.length - 1;
		List<Integer> result = new ArrayList<Integer>();

		for (int i = 0; i < nums1.length; i++) {
			int idx = binarySearch(nums2, nums1[i], low, high);
			if (idx != -1) {
				result.add(nums1[i]);
				low = idx + 1;
			}
		}

		int[] res = new int[result.size()];
		for (int i = 0; i < result.size(); i++) {
			res[i] = result.get(i);
		}

		return res;
	}

	private int binarySearch(int[] nums, int target, int low, int high) {
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] == target) {
				if (mid == low || nums[mid] > nums[mid - 1]) {
					return mid;
				} else {
					high = mid - 1;
				}
			} else if (nums[mid] < target) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}

	private void print(int[] nums) {
		for (int num : nums) {
			System.out.print(num + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		ArrayIntersection obj = new ArrayIntersection();
		int[] nums1 = { 1, 2, 2, 1 };
		int[] nums2 = { 2, 2 };
		int[] intersection = obj.intersect(nums1, nums2);
		System.out.println("Intersection Array: ");
		obj.print(intersection);
	}

}
