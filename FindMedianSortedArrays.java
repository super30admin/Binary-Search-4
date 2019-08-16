package binarySearch4;

public class FindMedianSortedArrays {

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
	int m = nums1.length;
	int n = nums2.length;
	if (m > n)
		return findMedianSortedArrays(nums2, nums1);
	int low = 0;
	int high = m;
	while (low <= high) {
		int px = (low + high)/2; // partition of nums1
		int py = (m + n + 1)/2 - px; // partition of nums2
		int maxLeftX = (px == 0) ? Integer.MIN_VALUE : nums1[px - 1];
		int minRightX = (px == m) ? Integer.MAX_VALUE : nums1[px];
		int maxLeftY = (py == 0) ? Integer.MIN_VALUE : nums2[py - 1];
		int minRightY = (py == n) ? Integer.MAX_VALUE : nums2[py];
		if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
			if (((m + n) % 2) == 0) {
				return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY))/2.0;
			} else {
				return Math.max(maxLeftX, maxLeftY) * 1.0;
			}
		} else if (maxLeftX > minRightY) {
			high = px - 1;
		} else {
			low = px + 1;
		}
	}
	return 0.0;
	}
}
