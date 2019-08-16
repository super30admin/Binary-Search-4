package binarySearch4;

public class H_Index_2 {

	public int hIndex(int[] citations) {
        int len = citations.length;
        if(len == 0)
            return 0;
        int end = len - 1;
        int mid = end/2;
        int start = 0;
        while(start < end) { // Base condition.
            if(citations[mid] >= len - mid) // to check H-Index.
                end = mid;
            else
                start = mid + 1;
            mid = (start + end)/2; // This will ensure the correct mid value.

        }
        if(citations[mid] >= len - mid) // Final check.
            return len - mid;
        else
            return 0;
    }
	
}
