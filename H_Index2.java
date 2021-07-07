package com.exmaple.problems;

//Time Complexity : O(N) for Linear SEarch Approach O(NLogn) for Binary Search
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

//Your code here along with comments explaining your approach

/*
We have used DP to cache the result of recursive apporach to avoid re-computation 
*/

public class H_Index2 {
	
	public int hIndex1(int[] citations) {
	    int idx = 0, n = citations.length;
	    for(int c : citations) {
	      if (c >= n - idx) return n - idx;
	      else idx++;
	    }
	    return 0;
	  }
	public int hIndex2(int[] citations) {
		int low = 0, high = citations.length - 1;

		while (low < high) {
			int mid = low + (high - low) / 2;
			int diff = citations.length - mid;
			if (citations[mid] == diff) {
				return diff;
			} else if (diff > citations[mid]) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return citations.length - low;
	}
}
