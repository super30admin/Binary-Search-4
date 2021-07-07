    /*  Explanation
    # Leetcode problem link : https://leetcode.com/problems/h-index-ii/
    Time Complexity for operators : o(logn) .. m and n are leangth of two different arrays
    Extra Space Complexity for operators : o(1) .. 
    Did this code successfully run on Leetcode : NA
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach : 
        # Optimized approach: 
                              
            # 1. 
                    A) Starting low = 0 and high = citations.length - 1;do the binary serach.
                    B) First claculate mid and then trial_index = len - mid
                    C) Check if trial_index == citations[mid] that means we found our h-index
                    D) If it is greater then mode low to mid+1
                    E) Else move high to the mid-1 

    */

class Solution {
    public int hIndex(int[] citations) {
        
        int low = 0;
        
        int high = citations.length - 1;
        
        int len = citations.length;
        
        while(low <= high){
            int mid = low + (high-low) / 2;
            
            int trial_index = len - mid;
            
            if(trial_index == citations[mid]){
                return trial_index;
            }else if(trial_index > citations[mid]){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return len - low;
    }
}