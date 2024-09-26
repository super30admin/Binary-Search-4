
//Time Complexity : O(M + N)
//Space Complexity: O(1)
import java.util.*;

public class Intersection_two_pointers {
	public int[] intersect(int[] nums1, int[] nums2) {
		if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0)
			return new int[0];
		int n1 = nums1.length;
		int n2 = nums2.length;
		if (n1 > n2)
			return intersect(nums2, nums1);
		List<Integer> list = new ArrayList<>();
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int p1 = 0;
		int p2 = 0;
		while (p1 < n1 && p2 < n2) {
			if (nums1[p1] == nums2[p2]) {
				list.add(nums1[p1]);
				p1++;
				p2++;
			} else if (nums1[p1] < nums2[p2]) {
				p1++;
			} else {
				p2++;
			}
		}
		int result[] = new int[list.size()];
		for (int i = 0; i < result.length; i++) {
			result[i] = list.get(i);
		}
		return result;
	}
}