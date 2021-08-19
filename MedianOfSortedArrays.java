// Time Complexity : O(log n), n -> Length of smaller array
// Space Complexity : O(1)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		if (nums1 == null && nums2 == null) {
			return 0.0;
		}

		if (nums1.length == 0 && nums2.length == 0) {
			return 0.0;
		}

		int n1 = nums1.length;
		int n2 = nums2.length;

		if (n1 > n2) {
			return findMedianSortedArrays(nums2, nums1);
		}

		int low = 0;
		int high = n1;
		int partitionX = 0;
		int partitionY = 0;

		while (low <= high) {
			partitionX = low + (high - low) / 2;
			partitionY = (n1 + n2) / 2 - partitionX;

			int l1 = partitionX == 0 ? Integer.MIN_VALUE : nums1[partitionX - 1];
			int l2 = partitionY == 0 ? Integer.MIN_VALUE : nums2[partitionY - 1];
			int r1 = partitionX == n1 ? Integer.MAX_VALUE : nums1[partitionX];
			int r2 = partitionY == n2 ? Integer.MAX_VALUE : nums2[partitionY];

			if (l1 <= r2 && l2 <= r1) {
				if ((n1 + n2) % 2 != 0) {
					return Math.min(r1, r2);
				} else {
					return (Math.min(r1, r2) + Math.max(l1, l2)) / 2.0;
				}
			} else if (l1 > r2) {
				high = partitionX - 1;
			} else if (l2 > r1) {
				low = partitionX + 1;
			}
		}
		return 0.0;
	}
}