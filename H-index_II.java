// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : After class solution


// Your code here along with comments explaining your approach
//We simply iterate over the array to find the condition that satisfies the h-index (citation >= n-i).

class Solution {
    public int hIndex(int[] citations) {
       
        //base check
        if(citations == null || citations.length == 0)
            return 0;
        
        int n = citations.length;
        
        for(int i=0; i<n; i++){
           int citation = citations[i];
            int count = n - i;
            
            if(citation >= count){
                return count;
            }
        }
        
        return 0;
    }
}

//============================================================================

// Time Complexity : O(Log(N))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : After class solution


// Your code here along with comments explaining your approach
//We use binary search to modify the above search value. Here, target is finding count.
//Count chnages with change in mid.
//We update low and high pointers
//At the end, we return n - low, if exact count value not found.

class Solution {
    public int hIndex(int[] citations) {
        
        //base check
        if(citations == null || citations.length == 0)
            return 0;
        
        int n = citations.length;
        int low = 0;
        int high = n - 1;
        
        while(low <= high){
            
            int mid = low + (high - low)/2;
            
            int citation = citations[mid];
            int count = n - mid;
            
            if(citation == count) return count;
            
            if(citation < count){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
            
        }
        
        return n - low;
    }
}