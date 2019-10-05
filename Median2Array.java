package binarySearch;

public class Median2Array {

	// Two pointer approach
	// calculate median index by nums1 +nums2 /2
	// we have to find elements from both the arrays which are less than median
	// index
	// if(nums1 < nums2)
	// increment tempMedianIndex and index of nums1
	// similarly increment index of nums2
	// keep repeating till our tempMedianIndex reached to desired median index.
	// if nums1 + nums2 is even then take median index and medianindex -1
	
	// TC = O(m + n)/2
	// SC= O(1)

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {

		int medianIndex = (nums1.length + nums2.length) / 2;
		boolean isEven = (nums1.length + nums2.length) % 2 == 0 ? true : false;
		int index1 = 0;
		int index2 = 0;
		int tempMedianIndex = 0;
		int medianNum = 0;
		int prevNo = 0;
		while (tempMedianIndex <= medianIndex) {

			if (index1 < nums1.length && index2 < nums2.length) {
				if (nums1[index1] < nums2[index2]) {
					prevNo = medianNum;
					medianNum = nums1[index1];
					index1++;
					tempMedianIndex++;
				} else {
					prevNo = medianNum;
					medianNum = nums2[index2];
					index2++;
					tempMedianIndex++;
				}

			} else
				break; // temp median is in second array
		}

		if (tempMedianIndex <= medianIndex) {
			if (index1 == nums1.length) {
				for (int start = tempMedianIndex; start <= medianIndex; start++) {
					prevNo = medianNum;
					medianNum = nums2[index2];
					index2++;
					tempMedianIndex++;
				}
			} else if (index2 == nums2.length) {
				for (int start = tempMedianIndex; start <= medianIndex; start++) {
					prevNo = medianNum;
					medianNum = nums1[index1];
					index1++;
					tempMedianIndex++;
				}
			}
		}

		if (isEven)
			return (double) (prevNo + medianNum) / 2;
		else
			return medianNum;
	}
}