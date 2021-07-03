// Time Complexity : O(log n) n-length of the array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// https://leetcode.com/problems/h-index-ii/
class Solution {
    public int hIndex(int[] citations) {
        if(citations==null || citations.length==0) return 0;
        int low=0; int high=citations.length-1;
        int n=citations.length;
        while(low<=high)
        {
            int i=low+(high-low)/2;
            if(citations[i]==n-i)
               return n-i;
            else if(citations[i]<n-i)
               low=i+1;
            else 
                high=i-1;
                
        }
      
     return n-low;

    }
}