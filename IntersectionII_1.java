package binarySearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionII_1 {
	public int[] intersect(int[] nums1, int[] nums2) {

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		List<Integer> resultList = new ArrayList<Integer>();
		int[] smaller;
		int[] larger;

		if (nums1.length < nums2.length) {
			smaller = nums1;
			larger = nums2;
		} else {
			smaller = nums2;
			larger = nums1;
		}

		for (int i = 0; i < larger.length; i++)
			map.put(larger[i], map.getOrDefault(larger[i], 0) + 1);

		for (int i = 0; i < smaller.length; i++) {

			if (map.containsKey(smaller[i])) {
				resultList.add(smaller[i]);

				Integer count = map.get(smaller[i]);
				count--;

				if (count != 0)
					map.put(smaller[i], count);
				else
					map.remove(smaller[i]);
			}

		}
		return listToArray(resultList);
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