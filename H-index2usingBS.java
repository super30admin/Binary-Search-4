class Solution {
    //difference beacome equal to citations or either citations are greater
    //TC: O(log n) n length of citations
    //SC: O(1)
    //using BS
    public int hIndex(int[] citations) {
       if(citations == null || citations.length == 0) return 0;
       int n =  citations.length;
       int low = 0;
       int high = n - 1;
       while(low <= high){
           int mid = low + (high - low)/2;
           if(citations[mid] == n - mid){
               return n-mid;
           }else if (citations[mid] < n-mid){
               low = mid + 1;
           }else high = mid - 1;
       }
       return n - low;
    }
}