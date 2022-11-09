// TC : O(logn)
// SC : O(1)
// Binary search solution
class Solution {
    public int hIndex(int[] citations) {
       if(citations == null || citations.length == 0) return -1; 
        int n = citations.length;
        int low = 0;
        int high = n - 1;
        
        
        while(low <= high) {
            
            int mid = low + (high - low)/2;
            
            if(n - mid == citations[mid])
                return n - mid;
            
            else if (n - mid < citations[mid])
                high = mid - 1;
            
            else
                low = mid + 1;
        }
        return n - low;
    }
}
