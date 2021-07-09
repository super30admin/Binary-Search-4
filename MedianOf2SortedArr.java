// Time Complexity : O(log m+n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no

/*
 * 1. consider two arrays as merged and try to find the mid index.
 * 2. when we split first array at an index, second array split point can be derived to make both left and right array size should be equal.
 * 3. when you know first array split we can get second array split by (n+m)/2-first array split index. 
 * 4. after split left part of split elements should be smaller than right side.
 * 5. compare l1,l2 with r2,r1 and adjust the first array split point accordingly.
 */
public class MedianOf2SortedArr {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		if (nums1.length > nums2.length)
			return findMedianSortedArrays(nums2, nums1);
		int low = 0;
		int high = nums1.length;
		while (low <= high) {
			int xpart = low + (high - low) / 2;
			double l1 = xpart == 0 ? Integer.MIN_VALUE : nums1[xpart - 1];
			double r1 = xpart == nums1.length ? Integer.MAX_VALUE : nums1[xpart];

			int ypart = (nums1.length + nums2.length) / 2 - xpart;
			double l2 = ypart == 0 ? Integer.MIN_VALUE : nums2[ypart - 1];
			double r2 = ypart == nums2.length ? Integer.MAX_VALUE : nums2[ypart];
			
			if(l1<=r2 && l2<=r1) {
				if((nums1.length+nums2.length)%2==0) {
					return (Math.max(l1, l2)+Math.min(r1, r2))/2;
				}else {
					return Math.min(r1, r2);
				}
				
			}else if (l2>r1) {
				low=xpart+1;
			}else {
				high=xpart-1;
			}
		}
		return 1d;
	}
}
