// Time Complexity : O(log N) since Binary Search is used
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int hIndex(int[] citations) {
        if(citations==null || citations.length==0){
            return 0;
        }
        
        int low = 0;
        int high = citations.length-1;
        int n = citations.length;
        
        
        while(low<=high)
        {
        int mid = low + (high-low)/2;

        //case 1:
        if(citations[mid] == n-mid){ return n-mid; }
        
        //case 2: 
        if(citations[mid] < n-mid){ low = mid + 1; }

        //case 3:
        if(citations[mid] > n-mid){ high = mid-1; }
        
        }
        
        return n-low;
    }
}
