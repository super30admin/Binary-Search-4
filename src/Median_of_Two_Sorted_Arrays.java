/********************************************Using Two Pointer Approach*************************************/
//Time Complexity :O(n+m), n and m are size of given two arrays
//Space Complexity :O(n), merged elements are stored in array
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/**Using Two Pointer Approach we merge both the arrays and find median
 * first we point at start of each array
 * Increment the pointer of array element smaller than the other and add it to merge array
 * If merged array size is odd, we find median by (mid + mid-1)/2 else we return mid* */

class Median_of_Two_Sorted_Arrays_BruteForce {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int[] mergeArray = new int[nums1.length + nums2.length];
		int pt1= 0, pt2 = 0;
		int i=0;
		while(pt1 < nums1.length && pt2 < nums2.length){
			if(nums1[pt1] <= nums2[pt2]){
				mergeArray[i] = nums1[pt1];
				pt1++;
			}
			else{
				mergeArray[i] = nums2[pt2];
				pt2++;
			}
			i++;
		}
		while(pt1 < nums1.length){
			mergeArray[i] = nums1[pt1];
			pt1++;
			i++;
		}
		while(pt2 < nums2.length){
			mergeArray[i] = nums2[pt2];
			pt2++;
			i++;
		}
		int mid = mergeArray.length / 2;
		if(mergeArray.length % 2 == 0)
			return ((double)mergeArray[mid] + (double)mergeArray[mid-1]) /2;
		else
			return (double)mergeArray[mid];
	}
}
/********************************************Using Binary Search*************************************/
//Time Complexity :O(log n), length of smaller array
//Space Complexity :O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/**Using Binary Search, find the partitions
 * We start by finding the mid (partX), then find the partition in the second array using the mid (partY)
 * Then find the start(l1, r1) and end(l2, r2) values for these partitions. 
 * if l1<=r2 and l2<=r1 and if length of given arrays is even, we find the median by (max(l1,l2) + min(r1,r2) /2)
 * if length of given arrays is odd, we find the median by max(l1,l2)
 * Move low pointer if l2 > r1 else move high* */

class Median_of_Two_Sorted_Arrays_BS{
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int low =0;
		int high = nums1.length;

		if (nums1.length > nums2.length) // to make nums1 as smaller one in length
			return findMedianSortedArrays(nums2, nums1);

		while(low <= high){
			int partX = low + (high - low)/2;
			int partY = (nums1.length + nums2.length +1)/2 - partX;
			double l1 = partX == 0 ? Integer.MIN_VALUE : nums1[partX-1];
			double r1 = partX == nums1.length ? Integer.MAX_VALUE : nums1[partX];
			double l2 = partY == 0 ? Integer.MIN_VALUE : nums2[partY-1];
			double r2 = partY == nums2.length ? Integer.MAX_VALUE : nums2[partY];

			if(l1 <= r2 && l2 <= r1){
				if((nums1.length + nums2.length) % 2 == 0)
					return (Math.max(l1, l2) + Math.min(r1, r2))/2;
				else
					return Math.max(l1, l2);
			}
			else if(l2 > r1)
				low = partX + 1;
			else
				high = partX - 1;
		}
		return -1;
	}
}