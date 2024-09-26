
//Time Complexity : O(MlogN)
//Space Complexity: O(1)
import java.util.*;

public class Intersection_BS {
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
		int index = 0;
		for (int num : nums1) {
			int bs = binarySearch(nums2, index, n2 - 1, num);
			if (bs != -1) {
				list.add(num);
				index = bs + 1;
			}
		}
		int result[] = new int[list.size()];
		for (int i = 0; i < result.length; i++) {
			result[i] = list.get(i);
		}
		return result;
	}

	private int binarySearch(int nums[], int low, int high, int target) {
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] == target) {
				if (low == mid || nums[mid] > nums[mid - 1]) {
					return mid;
				} else {
					high = mid - 1;
				}
			} else if (nums[mid] > target) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}
}