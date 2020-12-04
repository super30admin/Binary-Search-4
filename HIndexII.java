class HIndexII {
    
    //Method 1 - using binary search
    // Time complexity O(logn)
    // Space complexity O(1)
    // Tested in leetcode
    public int hIndex1(int[] citations) {
        //return 0 if input is invalid
        if(citations == null || citations.length == 0)
            return 0;
        
        int count = 0;
        int n = citations.length;
        int start = 0, end = n-1;
        
        while(start <= end){
            int mid = start + (end-start)/2;
            // if number of citations of paper at mid index is equal to total number of papers having citations greater than
            //or equal to citations of paper.then return index.
            if(citations[mid] == n-mid)
                return n - mid;
            //if citations of a paper at mid index is lesser search in right part of array.
            else if(citations[mid] < n-mid){
                start = mid+1;
            }
            //shift left
            else{
                end = mid -1 ;
            }
        }
        return n - start;
    }
    
    //Method 2 - linear approach
    // Time complexity O(n)
    // Space complexity O(1)
    // Tested in leetcode
    public int hIndex2(int[] citations) {
        //return 0 if input is invalid
        if(citations == null || citations.length == 0)
            return 0;
        
        int n = citations.length;
        int result = 0;
        
        //Check each paper citation greater than total number of paper of having citations greater than or equal to that number of citations
        for(int i=n-1; i>=0; i--){
            if(citations[i] >= n - i)
                result = n-i;
            else
                break;
        }
        return result;
    }
}