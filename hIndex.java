// Time Complexity :O(logN)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach





class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0) return 0;
        int left = 0 , right = citations.length -1 , mid = 0;
        int length = citations.length;
        while(left <= right){
            mid = left + (right - left )/2;
            
            if(citations[ mid ] == length - mid ){
                return length - mid; 
            }else if(citations[mid] < length - mid){ 
                left = mid +1 ;
            }else{
                right = mid - 1;
            }
        }
        return length - left;
    }
}
