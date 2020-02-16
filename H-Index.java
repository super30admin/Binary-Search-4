/*
 * Time complexity : O(log n)
 * Space Complexity : O(1)
 * 
 */
class Solution {
    public int hIndex(int[] citations) {
        
        if(citations == null || citations.length == 0){
            return 0;
        }
        
        int low = 0;
        int n = citations.length;
        int high = citations.length-1;
        
        while(low <= high){
            int mid = low + (high - low)/2;
            
            int val = citations[mid];
            int diff = n - mid;
            if(val == diff){
                return diff;
            }else if(diff > val){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        
        return n-low;
    }
}