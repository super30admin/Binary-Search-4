import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Time Complexity : O(m+n)
//Space Complexity :O(min(m,n))
//Did this code successfully run on Leetcode : yes
//Any problem you faced while coding this :no

/*
* 1. maintain a hash of first array elements with count.
* 2. loop through second array and if found add it to result.
*/
public class ArrayIntersectionUnsorted {
	public int[] intersect(int[] nums1, int[] nums2) {
		Map<Integer, Integer> map = new HashMap<>();
		
		if(nums1.length>nums2.length) return intersect(nums2,nums1);
		
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < nums1.length; i++) {
			map.compute(nums1[i], (k, v) -> v == null ? 1 : v + 1);
		}

		for (int i = 0; i < nums2.length; i++) {
			if (map.containsKey(nums2[i])) {
				result.add(nums2[i]);
				map.compute(nums2[i], (k, v) -> v == null ? 0 : v - 1);
				map.remove(nums2[i], 0);
			}
		}

		return result.stream().mapToInt(i -> i).toArray();
	}
	public static void main(String[] args) {
		System.out.println(Arrays.toString(new ArrayIntersectionUnsorted().intersect(new int[] {1,2,2,1}, new int[] {2,2})));
	}
}
