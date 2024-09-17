//Binary Search
// Time Complexity - O(logn)
// Space Complexity - O(1)

class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0)  return 0;
        int low = 0;      
        int n = citations.length;     
        int high = n -1;     
            while(low <= high)
             {int mid = low + (high - low)/2;      
             int val = citations[mid];            
             int diff = n - mid;                   
             if(val == diff) return val;
             else if(val < diff) 
             low = mid + 1;
             else 
            high = mid -1;
        }
        return n-low;        
    }
}

