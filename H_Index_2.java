package binarySearch4;

//According to the definition of h-index on Wikipedia: 
//"A scientist has index h if h of his/her N papers have at least h citations each, 
//and the other N − h papers have no more than h citations each."
public class H_Index_2 {

	public int hIndex(int[] citations) {
     
		// TC: O(logn) where n is the length of citations array, SC : o(1)
	    
	     int low = 0;
	        int len = citations.length;
	        int high = citations.length -1;
	        
	        while(low <= high) {
	            int mid = low + (high-low)/2;
	            if(citations[mid] == len - mid) return citations[mid];
	            
	            else if(citations[mid] > len - mid) high  = mid - 1;
	            else low = mid + 1;
	            
	        }
	        return len - (high + 1);
		/*
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
            
            */
    }
	
}
