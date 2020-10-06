
public class h_IndexII {

	public int hIndex(int[] citations) {
		
		if(citations == null || citations.length == 0)
			return 0;
		
		int left = 0, right = citations.length;
		int n = citations.length;
		
		while(left < right) {
			int mid = left + (right - left)/2;
			
			if(citations[mid] == n-mid)
				return n - mid;
			else if(citations[mid] < n - mid)
				left = mid+1;
			else
				right = mid;
		}
		return n - left;
	}
	
	public static void main(String[] args) {
		
		h_IndexII hi = new h_IndexII();
		int[] citations = {1, 2, 4, 7, 9, 10, 11};
		System.out.println(hi.hIndex(citations));
	}
}
