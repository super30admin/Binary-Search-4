package com.exmaple.problems;

import java.util.*;
//Time Complexity : O(N log N + M log M) for Two Pointer Approach,O(Nlog N) for Binary Search,O(N^2) for List and Set Based
// O(N + M) for HashMap
//Space Complexity : O(N) for HashMap,Two Pointer and Binary Search Set and List
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

//Your code here along with comments explaining your approach

/*
 * Binary Search Approach has to be modified to take care of duplicated values

*/
public class IntersectionArray {

	// HashMap Solution
	public int[] intersect3(int[] nums1, int[] nums2) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < nums1.length; i++) {
			if (map.containsKey(nums1[i]))
				map.put(nums1[i], map.get(nums1[i]) + 1);
			else
				map.put(nums1[i], 1);
		}

		for (int i = 0; i < nums2.length; i++) {
			if (map.containsKey(nums2[i]) && map.get(nums2[i]) > 0) {
				result.add(nums2[i]);
				map.put(nums2[i], map.get(nums2[i]) - 1);
			}
		}
		return result.stream().mapToInt(k -> k).toArray();
	}

	// Two Pointer Solution
	public int[] intersect(int[] nums1, int[] nums2) {
		List<Integer> set = new ArrayList<>();

		Arrays.sort(nums1);
		Arrays.sort(nums2);

		int i = 0, size1 = nums1.length, size2 = nums2.length, j = 0;
		while (i < size1 && j < size2) {
			if (nums1[i] == nums2[j]) {
				set.add(nums1[i]);
				i++;
				j++;
			} else if (nums1[i] < nums2[j]) {
				i++;
			} else {
				j++;
			}
		}
		return set.stream().mapToInt(k -> k).toArray();
	}

	// Binary Search Solution

	public int[] intersect1(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);

		List<Integer> nums1List = new ArrayList<>();

		for (int num : nums1)
			nums1List.add(num);

		List<Integer> ret = new LinkedList<>();

		for (int num : nums2) {
			int idx = search(nums1List, num);
			if (idx != -1) {
				nums1List.remove(idx);
				ret.add(num);
			}
		}
		int[] retArr = new int[ret.size()];
		int i = 0;
		for (int num : ret) {
			retArr[i++] = num;
		}
		return retArr;

	}

	public int search(List<Integer> nums, int key) {
		int high = nums.size() - 1, low = 0;

		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (nums.get(mid) == key)
				return mid;
			else if (nums.get(mid) > key)
				high = mid - 1;
			else
				low = mid + 1;
		}

		return -1;
	}

	// List Based Solution
	public int[] intersect2(int[] nums1, int[] nums2) {
		List<Integer> list = new ArrayList<>();
		List<Integer> set = new ArrayList<>();

		for (int num : nums1) {
			set.add(num);
		}
		for (int num : nums2) {
			if (set.contains(num)) {
				set.remove((Integer) num);
				list.add(num);
			}
		}
		return list.stream().mapToInt(k -> k).toArray();
	}

	public static void main(String args[]) {
		int nums1[] = { 1, 2, 2, 1 };
		int nums2[] = { 2, 2 };

		IntersectionArray inter = new IntersectionArray();
		System.out.println("Intersection of Arrays using Binary Search");
		int[] result = inter.intersect1(nums1, nums2);
		System.out.println(Arrays.toString(result));

		System.out.println("Intersection of Arrays using Two Pointer");
		result = inter.intersect(nums1, nums2);
		System.out.println(Arrays.toString(result));

		System.out.println("Intersection of Arrays using ArrayList and HashSet(Not Strictly using Set)");
		result = inter.intersect2(nums1, nums2);
		System.out.println(Arrays.toString(result));

		System.out.println("Intersection of Arrays using HashMap");
		result = inter.intersect3(nums1, nums2);
		System.out.println(Arrays.toString(result));

	}

}
