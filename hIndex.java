//Time complexity=O(logn)
//Space complexity=O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No 

class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0)return 0;
        int low = 0;
        int high = citations.length - 1;
        while(low <= high){
            int mid = low + (high - low)/2;
            int diff = citations.length - mid;
            if(citations[mid] == diff){
                return diff;    
            }else if( diff > citations[mid]){
                low  = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return citations.length - low;
    }
}