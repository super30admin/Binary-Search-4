//Time Complexity : O(logN)
//Space Complexity: O(1)
class H_index_BS {
	public int hIndex(int[] citations) {
		if (citations == null || citations.length == 0)
			return 0;
		int n = citations.length;
		int low = 0;
		int high = citations.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			int diff = n - mid;
			if (citations[mid] == diff)
				return diff;
			if (citations[mid] < diff)
				low = mid + 1;
			else
				high = mid - 1;
		}
		return n - low;
	}
}