//Time complexity is O(LogN)
//Space complexity is O(1)
//This solution is submitted on leetcode

public class BigN88HIndexBinarySearchLogNSolution {
	class Solution {
	    public int hIndex(int[] citations) {
	        //edge case
	        if(citations==null || citations.length==0)
	            return 0;
	        int low = 0;
	        int high = citations.length -1;
	        int n = citations.length;
	        while(low<=high){
	            int mid = low + (high-low)/2;
	            int val = citations[mid];
	            int diff = n - mid;
	            if(diff==val) return diff;
	            else if(val>diff) high = mid-1;
	            else low = mid+1;
	        }
	        return n - low;
	    }
	}
}