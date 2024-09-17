// Time Complexity  - O(log(min(m,n)))
// Space Complexity - 0(1) - Constant space
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No

public class MedianTwoSortedArray {
	
	public double findMedianSortedArrays(int[] x, int[] y) {
		
		int xLen = x.length;
		int yLen = y.length;
		
		if(xLen>yLen) {
			return findMedianSortedArrays(y,x);
		}
		
		int left = 0, right = xLen;
		int partitionX, partitionY, maxLeftX, maxLeftY, minRightX, minRightY;
		
		while(left<=right) {
			
			partitionX = (left+right)/2;
			partitionY = (xLen + yLen +1)/2 - partitionX;
			
			if(partitionX == 0) {
				maxLeftX = Integer.MIN_VALUE;
			}else {
				maxLeftX = x[partitionX-1];
			}
			
			if(partitionX == xLen) {
				minRightX = Integer.MAX_VALUE;
			}else {
				minRightX = x[partitionX];
			}
			
			if(partitionY == 0) {
				maxLeftY = Integer.MIN_VALUE;
			}else {
				maxLeftY = y[partitionY-1];
			}
			
			if(partitionY == yLen) {
				minRightY = Integer.MAX_VALUE;
			}else {
				minRightY = y[partitionY];
			}
			
		
			if(maxLeftX <= minRightY && maxLeftY <= minRightX) {
				if((xLen+yLen) %2 == 0) {
					
					return (Math.max(maxLeftX, maxLeftY) + Math .min(minRightX, minRightY) )/2;
					
				}else {
					return Math.max(maxLeftX,maxLeftY);
				}
			}else if(maxLeftX > minRightY) {
				right = partitionX-1;
			}else {
				left = partitionX+1;
			}


			
		}
		
		
		return 0;
    }
	
	
	public static void main(String[] args) {
		MedianTwoSortedArray m = new MedianTwoSortedArray();
		double median = m.findMedianSortedArrays(new int[] {1,4,7,10,16},new int[] {8,12,17,20,22,26}  );
		System.out.println(median);

	}

}
