//Leetcode 275. H-Index II
//Time Complexity: O(logn)
//Space Complexity: O(1)
class Solution {
    public int hIndex(int[] citations) {
        if(citations==null || citations.length==0 ) return 0;
     int diff;
        int low=0;
        int high=citations.length-1; 
       while(low<=high){
         
           int mid= low+(high-low)/2;
            diff=citations.length-mid;
           if(citations[mid]-diff==0) return diff;
           if(citations[mid]<diff) low= mid+1;
           else high=mid-1;
       }
    
        return citations.length-low;
    }
}
