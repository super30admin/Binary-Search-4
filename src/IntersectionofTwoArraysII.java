import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
 * Time Complexity of the algorithm is O(m log n) where m is no of elements in first array and n  no of elements in second array
 * space Complexity will O(n) where n is size of no of elements in smallest array
 */

public class IntersectionofTwoArraysII {

	// binary search

	public int[] intersect1(int[] nums1, int[] nums2) {

		if (nums1 == null && nums2 == null || nums1.length == 0 && nums2.length == 0)
			return new int[] {};

		HashMap<Integer, Integer> map = new HashMap<>();

		List<Integer> result = new ArrayList();

		int n1 = nums1.length, n2 = nums2.length;

		Arrays.sort(nums1);
		Arrays.sort(nums2);

		if (n1 > n2)
			return intersect1(nums2, nums1);
		int low = 0;

		for (int i = 0; i < n1; i++) {

			int index = binarySearch(nums2, nums1[i], low, n2 - 1);

			if (index != -1) {

				result.add(nums1[i]);
				low = index + 1;
			}

		}

		int[] result1 = new int[result.size()];

		for (int i = 0; i < result.size(); i++) {

			result1[i] = result.get(i);
		}

		return result1;

	}

	private int binarySearch(int[] nums2, int target, int low, int high) {

		while (low <= high) {

			int mid = low + (high - low) / 2;

			if (nums2[mid] == target) {

				if (mid == low || nums2[mid] > nums2[mid - 1]) {

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

	// Map approach

	public int[] intersect(int[] nums1, int[] nums2) {

		if (nums1 == null && nums2 == null || nums1.length == 0 && nums2.length == 0)
			return new int[] {};

		HashMap<Integer, Integer> map = new HashMap<>();

		List<Integer> result = new ArrayList();

		int n1 = nums1.length, n2 = nums2.length;

		if (n1 > n2) {

			for (int input : nums2) {

				map.put(input, map.getOrDefault(input, 0) + 1);

			}

			for (int input : nums1) {

				if (map.containsKey(input)) {

					map.put(input, map.get(input) - 1);
					map.remove(input, 0);
					result.add(input);
				}
			}

		} else {

			for (int input : nums1) {

				map.put(input, map.getOrDefault(input, 0) + 1);

			}

			for (int input : nums2) {

				if (map.containsKey(input)) {

					map.put(input, map.get(input) - 1);
					map.remove(input, 0);
					result.add(input);
				}
			}

		}

		int[] result1 = new int[result.size()];

		for (int i = 0; i < result.size(); i++) {

			result1[i] = result.get(i);
		}

		return result1;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
