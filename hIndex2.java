/*
Citations are stored in sorted order.
*/
class Solution {
    public int hIndex(int[] citations) {
        //return hIndexLinear(citations);
        return hIndexBinarySearch(citations);
    }
    
    /* time complexity: O(n) n is total citations. 
    Space complexity: O(1)
    */
    private int hIndexLinear(int[] citations){
        int n = citations.length;
        for(int i =0; i< citations.length; i++){
             //lets say paper whose citation number is citationCount is at index i
            int citationCount = citations[i];
            /*so from this we would know that number of papers whose citation count is higher than citationCount
            higher than this would be len - i -1;
            with the current article there are n-i articles whose citation count is at least citationCount
            
            so we need to find the first article, at i whose citation number c= citation[i] greater than 
            or equal to n-i
            */
            if(citationCount >= n- i) 
                return n-i;
        }
        return 0;
    }
    /* 
    Binary Search Approach
    time complexity: O(logn) n is total citations. 
    Space complexity: O(1)
    */
    private int hIndexBinarySearch(int [] citations){
        int n = citations.length;
        int high = citations.length-1;
        int low = 0;
        while(low <= high){
            int mid = low + (high - low )/2;
            if(citations[mid] == n- mid ) return n - mid;
            else if(citations[mid] < n-mid) low = mid+1;
            else high = mid-1;
        }
        return n - low;
    }
}
