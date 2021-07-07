// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class HIndex2 {
    // time : O(log(n))
    public int hIndex(int[] citations) {
        int n = citations.length;
        int low = 0;
        int high = n - 1;

        while(low <= high){
            int mid = low + (high - low)/2;
            if(citations[mid] == n - mid){
                return n - mid;
            } else if (citations[mid] < n - mid){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return n - low;
    }

//     time complexity : O(N)
     public int hIndexBF(int[] citations) {
         int i = 0;
         int n = citations.length;
         // As we know, c = citations[i] and we need at least c citations more than N - i
         for(int c : citations){
             if(c >= (n - i)){
                 return n-i;
             }
             i++;
         }

         return 0;
     }
}
