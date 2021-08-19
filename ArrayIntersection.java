// Time Complexity : O(mlog n), m -> Length of nums1 (smaller array), n -> Length of nums2 (larger array)
// Space Complexity : O(m)
class Solution {
	public int[] intersectBinarySearch(int[] nums1, int[] nums2) {
		if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
			return new int[0];
		}

		if (nums1.length > nums2.length) {
			return intersect(nums2, nums1);
		}

		Arrays.sort(nums1);
		Arrays.sort(nums2);

		int low = 0;
		int high = nums2.length - 1;
		List<Integer> result = new ArrayList<Integer>();

		for (int i = 0; i < nums1.length; i++) {
			int idx = binarySearch(nums2, nums1[i], low, high);
			if (idx != -1) {
				result.add(nums1[i]);
				low = idx + 1;
			}
		}

		int[] res = new int[result.size()];
		for (int i = 0; i < result.size(); i++) {
			res[i] = result.get(i);
		}

		return res;
	}

	private int binarySearch(int[] nums, int target, int low, int high) {
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] == target) {
				if (mid == low || nums[mid] > nums[mid - 1]) {
					return mid;
				} else {
					high = mid - 1;
				}
			} else if (nums[mid] < target) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}
}