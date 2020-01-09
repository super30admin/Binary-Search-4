//Binary Search
// Time Complexity - O(logn)
// Space Complexity - O(1)

class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0)  return 0;
        int low = 0;      // low starts at 0
        int n = citations.length;     //length of the citations array
        int high = n -1;     // high is at the end of the array in the start
        while(low <= high){               // Iterate until high crosses low
            int mid = low + (high - low)/2;       //  get the mid
            int val = citations[mid];             // Val if the citation at mid
            int diff = n - mid;                   // Diff is the number of papers that have 
            if(val == diff) return val;
            else if(val < diff) low = mid + 1;
            else high = mid -1;
        }
        return n-low;        
    }
}



// Brute Force
// Time Complexity - O(n)
// Space Complexity - O(1)

