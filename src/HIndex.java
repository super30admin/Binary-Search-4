// Time Complexity : O(log n )
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

/** // diff for i th paper - number of papers having citations >= citations[i] (i.e n - i)
 * find the index where this diff matches citations or citations just cross this difference
 * https://leetcode.com/problems/h-index-ii
 *
 */
class Solution {
    public int hIndex(int[] citations) {
        
        if(citations == null || citations.length == -1) return -1;
        
        int low = 0, high = citations.length-1, n = citations.length;
        
        while(low<=high){
            
            int mid = low + (high - low)/2;
            
            // diff for i th paper - number of papers having citations >= citations[i] (i.e n - i)
            int diff = n - mid;
            
            //if citations equal to diff, that is h index
            if(citations[mid] == diff) {
                return n - mid;
            }else if(citations[mid] < diff) {
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        
        //if citations = diff condition not found above, next condition
        // if where citations just cross diff, current low will point to that index in citations array
        return n - low;
    }
}