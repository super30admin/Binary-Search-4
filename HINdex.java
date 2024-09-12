//TC: O(logn)
//SC: O(1)

public class HINdex {
    public int hIndex(int[] citations) {
        int len = citations.length;
        int high = len-1;
        int low = 0;
        // We search for mid such that citations[mid] == len-mid
        // if not found such mid return len-low
        while(low<=high){
            int mid = (low+high)/2;
            
            if(citations[mid]==len-mid)
                return len-mid;
            if(citations[mid]<len-mid)
                low = mid+1;
            else
                high = mid-1;
        }        
        return len-low;
    }
}