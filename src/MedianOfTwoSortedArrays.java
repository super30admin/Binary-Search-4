//Time Complexity : O(log(N + M))
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No
/**
 * For getting median, we have to split the two arrays in such a way that left
 * halves of the two arrays sizes = right halves of the two arrays. Then we have
 * to verify if left sub array of 1st array's last element < 1st element of
 * right subarray of 2nd array and similarly for the other two halves. If
 * satisfied, then the median is found, else we have to move our partitions
 * based on the above conditions.
 *
 */
class Solution {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int n1 = nums1.length, n2 = nums2.length;
		if (n1 > n2) {
			return findMedianSortedArrays(nums2, nums1);
		}

		int left = 0, right = nums1.length;
		double mid = 0;
		while (left <= right) {
			int part1 = (left + right) / 2;
			int part2 = (n1 + n2 + 1) / 2 - part1;
			int l1 = part1 == 0 ? Integer.MIN_VALUE : nums1[part1 - 1];
			int l2 = part2 == 0 ? Integer.MIN_VALUE : nums2[part2 - 1];
			int r1 = part1 == n1 ? Integer.MAX_VALUE : nums1[part1];
			int r2 = part2 == n2 ? Integer.MAX_VALUE : nums2[part2];

			if (l1 <= r2 && l2 <= r1) {
				if ((n1 + n2) % 2 == 0)
					mid = (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
				else
					mid = Math.max(l1, l2);
				break;
			} else if (l1 > r2) {
				right = part1 - 1;
			} else {
				left = part1 + 1;
			}
		}
		return mid;
	}
}