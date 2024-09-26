//Time Complexity : O(N)
//Space Complexity: O(1)
class Solution {
	public int hIndex(int[] citations) {
		if (citations == null || citations.length == 0)
			return 0;
		int n = citations.length;
		for (int i = 0; i < n; i++) {
			int diff = n - i;
			if (citations[i] >= diff)
				return diff;
		}
		return 0;
	}
}