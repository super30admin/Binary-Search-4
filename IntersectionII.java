package binarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionII {
	public int[] intersect(int[] nums1, int[] nums2) {

		Arrays.sort(nums1);
		Arrays.sort(nums2);

		List<Integer> result = new ArrayList<Integer>();
		int index1 = 0;
		int index2 = 0;

		while (index1 < nums1.length && index2 < nums2.length) {

			if (nums1[index1] == nums2[index2]) {
				result.add(nums1[index1]);
				index1++;
				index2++;

			} else if (nums1[index1] < nums2[index2])
				index1++;
			else if (nums1[index1] > nums2[index2])
				index2++;

		}

		return listToArray(result);

	}

	private int[] listToArray(List<Integer> result) {
		int[] resultArray = new int[result.size()];
		int index = 0;
		for (Integer res : result) {
			resultArray[index] = res;
			index++;
		}
		return resultArray;
	}
}