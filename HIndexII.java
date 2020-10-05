// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Binary search 
class Solution {
    public int hIndex(int[] citations) { 
        if(citations == null || citations.length==0)
            return 0;
        
        int index = 0;
        int n = citations.length;
        int mid = 0;
        int lo = 0;
        int hi = n - 1;
        
        while (lo <= hi) {
          mid = lo + (hi - lo) / 2; 
          if (citations[mid] == n - mid){
              return n - mid;
          } else if(citations[mid] < n - mid){ 
              lo =  mid + 1;
          } else{
              hi = mid - 1;
          }
        }
        return n - lo;
    }
}