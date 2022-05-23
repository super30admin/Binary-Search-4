// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int hIndex(int[] citations) {
        
        
        if(citations == null || citations.length == 0) {
            return 0;
        }
        
        int low = 0;
        int high = citations.length - 1;
        int n = citations.length;
        
        while(low <= high) {
            int mid = low + (high - low) / 2;
            int index = n - mid;
            if(citations[mid] == index) {
                return index;
            }
            
            if(citations[mid] > index) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return n - low;
    }
}