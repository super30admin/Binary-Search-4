class Solution {
        // Time Complexity : O(N)  N: No. of papers
// Space Complexity : O(1)  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

 /* 
 Bruteforce
 */
    public int hIndex(int[] citations) {
        int n = citations.length;
        for(int i =0; i<n;i++){
            if(citations[i] >= (n-i)){
                return (n-i);
            }
        }
        return 0;
    }
}




class Solution {
        // Time Complexity : O(logN)  N: No. of papers
// Space Complexity : O(1)  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

 /* 
 BinarySearch
 */
    public int hIndex(int[] citations) {
        int n = citations.length;
        if((n == 0) || citations[n-1]==0) return 0;
        
        int lo =0; int hi = n-1; 
        while(lo < hi){
            int mid = lo+(hi-lo)/2;
            int diff = n-mid;
            if(citations[mid] == diff)
                return diff;
            else if(citations[mid]< diff)
                lo=  mid+1;
            else
                hi  = mid;
        }
        return (n-lo);
    }
}