//Time Complexity: O(log(n))
//Binary Search

class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0)
            return 0;
        
        int low = 0;
        int n = citations.length;
        int high = n-1;
        while(low <= high){
            int mid = low + (high - low)/2;
            int val = citations[mid];
            int diff = n - mid;
            if(val == diff)
                return val;
            if(val < diff)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return n - low;
    }
}

/******************************************************* */
//Brute Force
//Time Complexity: O(n)

class Solution {
    public int hIndex(int[] citations) {
        //base case
        if(citations == null || citations.length == 0)
            return 0;   
            
        int val = 0;                    //actual value 
        int diff = 0;                   //difference between n and ith element
        int n = citations.length;
        for(int i=0; i<n; i++){
            val = citations[i];
            diff = n - i;
            //where the sign changes, return those many elements
            if(val >= diff)
                return diff;
        }
        return 0;
    }
}
