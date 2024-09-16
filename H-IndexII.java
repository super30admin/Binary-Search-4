// Time Complexity : O(  log n) n = elements in a and citations array.
 
// Space Complexity : O(1)

// Did this code successfully run on Leetcode :yes. 

// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//  do a binary search  but not using mid, we use length of array - mid to find value;

//Runtime: 0 ms, faster than 100.00% of Java online submissions for H-Index II.
//Memory Usage: 46.8 MB, less than 64.32% of Java online submissions for H-Index II.
class Solution {
    public int hIndex(int[] citations) {
        if (citations==null || citations.length==0)
            return 0;
        int l=0;
        int h=citations.length-1;
        while (l<=h){
            int mid= l + (h-l)/2;
            if (citations[mid]==(citations.length-mid))
               return citations.length-mid;    
            else if (citations[mid]<(citations.length-mid))
                l=mid+1;
            else
               h=mid-1;
        }    
        
        return citations.length-l; 
    }
}