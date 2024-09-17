// Time Complexity  - O(nlogn + mlogm)
// Space Complexity - 0(1) - Constant space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No




import java.util.*;

public class IntersectionTwoArrays {

	public int[] intersectBruteForce(int[] nums1, int[] nums2) {

		List<Integer> list = new ArrayList<>();

		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i : nums1) {
//			if(!map.containsKey(i)) {
//				map.put(i,0);
//			}{
//				map.put(i,map.getOrDefault(i, 0)+1);
//			}

			map.put(i, map.getOrDefault(i, 0) + 1);
		}

		for (int i : nums2) {
			if (map.containsKey(i)) {
				if (map.get(i) != 0) {
					list.add(i);
					map.put(i, map.get(i) - 1);
				}
			}
		}

		int[] res = new int[list.size()];
		int i = 0;
		for (int val : list) {
			res[i++] = val;
		}
		return res;

	}

	public int[] intersect(int[] nums1, int[] nums2) {

		List<Integer> list = new ArrayList<>();

		Arrays.sort(nums1);
		Arrays.sort(nums2);

		int firstPtr=0, secondPtr=0;
		
		while(firstPtr<nums1.length && secondPtr <nums2.length) {
			if(nums1[firstPtr] == nums2[secondPtr]) {
				list.add(nums1[firstPtr]);
				firstPtr++;
				secondPtr++;
			}else if(nums1[firstPtr] > nums2[secondPtr]){
				secondPtr++;
			}else {
				firstPtr++;
			}
		}

		int[] res = new int[list.size()];
		int i = 0;
		for (int val : list) {
			res[i++] = val;
		}
		return res;

	}

	public static void main(String[] args) {
		int[] nums1 = { 4, 5, 9 };
		int[] nums2 = { 9, 4, 9, 8, 4 };

		IntersectionTwoArrays i = new IntersectionTwoArrays();
		i.intersect(nums1, nums2);
	}

}
