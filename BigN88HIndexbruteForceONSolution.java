// Time complexity is O(N)
// Space complexity is O(1)
// This solution is submitted on leetcode

public class BigN88HIndexbruteForceONSolution {
	class Solution {
		public int hIndex(int[] citations) {
			// edge case
			if (citations == null || citations.length == 0)
				return 0;
			int val = 0;
			int diff = 0;
			int n = citations.length;
			for (int i = 0; i < n; i++) {
				val = citations[i];
				diff = n - i;
				if (val >= diff)
					return diff;
			}
			return 0;
		}
	}
}