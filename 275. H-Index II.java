// Time Complexity: O()
// Space Complexity: O()
// Did this code successfully run on Leetcode: YES
// Any problem you faced while coding this: NO

// Your code here along with comments explaining your approach:  Used binary search to find if the index and the value at that index and there after are equal or greater than the index

class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0) return 0;
        
        int n = citations.length;
        int low = 0, high = n - 1;
        
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(citations[mid] >= n - mid){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return n - low;
    }
}