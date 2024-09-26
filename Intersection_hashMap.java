
//Time Complexity : O(M + N)
//Space Complexity: O(M)
import java.util.*;

class Solution1 {
	public int[] intersect(int[] nums1, int[] nums2) {
		if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0)
			return new int[0];
		int n1 = nums1.length;
		int n2 = nums2.length;
		if (n1 > n2)
			return intersect(nums2, nums1);
		List<Integer> list = new ArrayList<>();
		HashMap<Integer, Integer> hmap = new HashMap<>();
		for (int num : nums1) {
			hmap.put(num, hmap.getOrDefault(num, 0) + 1);
		}
		for (int num : nums2) {
			if (hmap.containsKey(num)) {
				hmap.put(num, hmap.get(num) - 1);
				hmap.remove(num, 0);
				list.add(num);
			}
		}
		int result[] = new int[list.size()];
		for (int i = 0; i < result.length; i++) {
			result[i] = list.get(i);
		}
		return result;
	}
}