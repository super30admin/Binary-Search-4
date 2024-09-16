//Time complexity- O(log n)
//Space complexity- O(1)
//Sucessfully ran on leetcode

class Solution {
 public int hIndex(int[] citations) {
     
     if(citations==null || citations.length==0) return 0;
     
     int n= citations.length;
     
     int low= 0;
     int high= n-1;
     int mid=0;
     while(low<= high){
          mid= low+ (high-low)/2;
         if(citations[mid] >= n - mid){
             high = mid-1;
         }
         else low= mid+1;
     }
     return n - low;
 }
}
