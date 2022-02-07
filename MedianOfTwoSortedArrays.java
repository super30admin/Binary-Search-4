package binarySearch4;

public class MedianOfTwoSortedArrays {
	//Time Complexity : O(log n), where n are the elements from min sized array
	//Space Complexity : O(1)
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : Followed class
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length)
            return findMedianSortedArrays(nums2, nums1);
        
        int low = 0;
        int high = nums1.length;
        while(low <= high) {
            int partX = low + (high - low) / 2;
            int partY = (nums1.length + nums2.length)/2 - partX;
            
            double L1 = partX == 0 ? Integer.MIN_VALUE: nums1[partX - 1];
            double R1 = partX == nums1.length ? Integer.MAX_VALUE: nums1[partX];
            double L2 = partY == 0 ? Integer.MIN_VALUE: nums2[partY - 1];
            double R2 = partY == nums2.length ? Integer.MAX_VALUE: nums2[partY];
            
            if(L1 <= R2 && L2 <= R1) {
                if((nums1.length + nums2.length) % 2 == 0) {
                    return (Math.max(L1, L2) + Math.min(R1, R2)) / 2;
                } else {
                    return Math.min(R1, R2);
                }
            } else if(L2 > R1) {
                low = partX + 1;
            } else {
                high = partX - 1;
            }
        }
        
        return 0.0;
    }
}
