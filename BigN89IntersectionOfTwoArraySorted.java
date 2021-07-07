import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Time complexity is O(m+n)
//Space is O(m+n) as we are using an list
//This solution is submitted on leetcode

public class BigN89IntersectionOfTwoArraySorted {
	class Solution {
		public int[] intersect(int[] nums1, int[] nums2) {
			// two pointer solution
			// egde case
			if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0)
				return new int[] {};
			Arrays.sort(nums1);
			Arrays.sort(nums2);
			List<Integer> temp = new ArrayList<>();
			int p1 = 0;
			int p2 = 0;
			while (p1 < nums1.length && p2 < nums2.length) {
				if (nums1[p1] == nums2[p2]) {
					temp.add(nums1[p1]);
					p1++;
					p2++;
				} else if (nums1[p1] > nums2[p2]) {
					p2++;
				} else
					p1++;
			}
			int[] result = new int[temp.size()];
			for (int k = 0; k < temp.size(); k++) {
				result[k] = temp.get(k);
			}
			return result;
		}
	}
}