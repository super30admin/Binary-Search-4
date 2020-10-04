// Time Complexity : O(logn) 
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int hIndex(int[] citations) {
        
        int low = 0;
        int high = citations.length-1;
        
        while(low<=high){
            int mid = low + (high-low)/2;
            
           int trial_index = citations.length-mid;
            
            if(trial_index==citations[mid]){
                return trial_index;
            }else if(trial_index>citations[mid]){
                low=mid+1;
            }else{
                high =mid-1;
            }
        }
        return citations.length-low;
    }
}