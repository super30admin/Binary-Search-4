class HIndex {
	public int hIndex(int[] citations) {
		if (citations == null || citations.length == 0)
			return 0;
		int n = citations.length;
		for (int i = 0; i < n; i++) {
			int val = citations[i];
			int diff = n - i;
			if (val == diff)
				return val;
			if (val > diff)
				return n - i;
		}
		return 0;
	}
}