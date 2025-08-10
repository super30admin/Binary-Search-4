// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Approach : use binary search to check if at mid citations[i] can be h index, if yes return. If citations[i] if 
/// less thna no. of pages, there might be a higher value to right so move low = mid+1, else high = mid-1
class Solution {
    public int hIndex(int[] citations) {
        int low = 0, high = citations.length-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            int diff = citations.length-mid;
            if(diff == citations[mid]){
                return citations[mid];
            }
            else if(citations[mid] < diff){
                low = mid+1;
                
            }
            else{
                high = mid-1;
            }
        }
        return citations.length-low;
    }
}