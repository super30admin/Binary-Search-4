// TC: O(log(min(x,y)) where x is length of one array and y is length of one array
// SC : O(1) constant space

// We find the partition between 2 arrays where the length of the sum of partitions can be same or if length is odd, we check if the 
// left parition last element in X array is less than right partition of first element in Y array, and left partition last element of Y array
// is less than first element of X right partition. SO basically once we have a partition where the elements on the left of X and Y arrays are less than
// elements on right side of the both array partition, if so, we find the median, if even length, we find mean of 4 elements from 4 parition
// if odd length, we find the max value of left partition of both arrays.

public class MedianTwoSorted {

	public double median(int[] nums1, int[] nums2) {
		
		if(nums1.length > nums2.length)
			return median(nums2, nums1);
		
		int x = nums1.length;
		int y = nums2.length;
		int st = 0, end = x;
		
		while(st <= end) {
			
			int partitionX = st+(end-st)/2;
			int partitionY = (x+y+1)/2 - partitionX;
			
			// Edge case
			int maxLeftX = partitionX == 0? Integer.MIN_VALUE: nums1[partitionX-1];  // we can have 0 values in left partition, here we can assign minvalue
			int minRightX = partitionX == x? Integer.MAX_VALUE: nums1[partitionX]; // if we have all the values on the left and 0 values on right, we assign maximum value since we know elements 
			// on the right partition should be greater than elements on the left partition
			
			int maxLeftY = partitionY == 0? Integer.MIN_VALUE: nums2[partitionY - 1];// we can have 0 values in left partition, here we can assign minvalue
			int minRightY = partitionY == y? Integer.MAX_VALUE: nums2[partitionY]; // if we have all the values on the left and 0 values on right, we assign maximum value since we know elements 
			// on the right partition should be greater than elements on the left partition
			
			if(maxLeftX <= minRightY && maxLeftY <= minRightX) {
				
				if((x+y)%2 == 0)
					return (double)((Math.max(maxLeftX,  maxLeftY)) + Math.min(minRightX, minRightY))/2; 
				else
					return (double) (Math.max(maxLeftX, maxLeftY));
			}else if( maxLeftX > minRightY)
				end = partitionX - 1;
			else
				st = partitionX +1;
		}
		
		throw new IllegalArgumentException("Invalid");
		
	}
	
	public static void main(String[] args) {
		
		MedianTwoSorted mts = new MedianTwoSorted();
		int[] nums1 = {23, 26, 31, 35};
		int[] nums2 = {3, 5, 7, 9, 11, 16};
		System.out.println(mts.median(nums1, nums2));
	}
}
