//idea is to first check median value weather it is hindex or not means to check weather no of paper after median are equal to median value or not.
//no of paper after median >median value then move low pointer from start to median+1 else move high to median-1. if no paper value is not present in array thrn return
//arraylength- low Index
//tc o(logn)
//sc:o(1)


public class HIndex2 {
		   public static int hIndex(int[] citations) {
			int len = citations.length;
			int lo = 0, hi = len - 1;
			while (lo <= hi) {
				int med = (hi + lo) / 2;
				if (citations[med] == len - med) {
					return len - med;
				} else if (citations[med] < len - med) {
					lo = med + 1;
				} else { 
					//(citations[med] > len-med), med qualified as a hIndex,
				    // but we have to continue to search for a higher one.
					hi = med - 1;
				}
			}
			return len - lo;
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] citation = {0,1,3,5,6};
		int hindex = hIndex(citation);
		System.out.println("hindex is"+hindex);

	}

}
