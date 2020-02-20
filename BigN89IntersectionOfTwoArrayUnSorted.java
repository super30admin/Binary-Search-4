// Time complexity is O(m*n)
// Space is O(m+n) as we are using an list
// This solution is submitted on leetcode

import java.util.ArrayList;
import java.util.List;

public class BigN89IntersectionOfTwoArrayUnSorted {
	class Solution {
		public int[] intersect(int[] nums1, int[] nums2) {
			// egde case
			if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0)
				return new int[] {};
			List<Integer> temp = new ArrayList<>();
			for (int i = 0; i < nums1.length; i++) {
				for (int j = 0; j < nums2.length; j++) {
					if (nums1[i] == nums2[j]) {
						temp.add(nums2[j]);
						nums2[j] = -1 * nums2[j];
						break;
					}
				}
			}
			int[] result = new int[temp.size()];
			for (int k = 0; k < temp.size(); k++) {
				result[k] = temp.get(k);
			}
			return result;
		}
	}
}