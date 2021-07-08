
//TimeComplexity :O(logn)
//Space Complexity :O(1);
//Did it run on leetcode : yes


class Solution {
    public int hIndex(int[] citations) {
        
   
        
        int low = 0 ;
        int high  = citations.length -1 ;
        int n = citations.length;
    while(low <= high){
     int mid  = low + (high -low)/2;
      int diff = n - mid;
      if(citations[mid] == diff)
         return diff;
      else if(citations[mid] < diff)
          low = mid+1;
      else 
          high = mid -1 ;
    }
        return n - low;
  }
}





