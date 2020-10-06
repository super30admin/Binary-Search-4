// Time Complexity : O(logn) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int hIndex(int[] citations) {
        int left = 0, right = citations.length, mid = 0;
        int hIndex = 0;
        int len = citations.length;
        
        while(left < right){
            mid = left + (right - left)/2;
            
            hIndex = citations[mid]; 
            
            if(hIndex == len - mid){    //if it is valid hIndex then return it
                return len - mid;
            }else if(hIndex > len - mid){   //else divide the search space into half if the hindex is greater than the n (length of array - mid) papers
                right = mid;
            }else{
                left = mid+1;
            }
        }
      
        return len - left;  
        
    }
}
