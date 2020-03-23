// Time Complexity  - O(nlogn)
// Space Complexity - 0(1) - Constant space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No



import java.util.*;

public class HIndexII {

	public int hIndexLinear(int[] citations) {

		int length = citations.length;
		for (int i = 0; i < length; i++) {

			int citation = citations[i];
			int count = length - i;

			if (citation >= count) {
				return count;
			}

		}

		return 0;

	}
	
	
	public int hIndex(int[] citations) {

		int high =citations.length;
		int length = citations.length;
		int low=0;
		while(low<=high) {
			
			int mid = low+ (high-low)/2;
			int citation =citations[mid];
			int count = length-mid;
			if(citation >= count)
				return count;
			if(citation< count)
				low = mid+1;
			else
				high = low-1;
				
						
			
		}
		return length - low;

	}


	public static void main(String[] args) {

		HIndexII h = new HIndexII();
		int hIndex = h.hIndex(new int[] { 0, 1, 3, 5, 6 });
		System.out.println(hIndex);

	}

}
