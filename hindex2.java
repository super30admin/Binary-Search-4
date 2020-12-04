class Solution {
   public int hIndex(int[] citations) {
        int N = citations.length;

        int l = 0, r = N-1;
        int mid = 0;
        while(l<r){
           mid = l+(r-l)/ 2;
           if(citations[mid] < N - mid){
               l = mid + 1;
           }
           else if(citations[mid] > N - mid){
               r = mid;
           }
           else{
               return N-mid;
           }
        }
        
        if(l<N && citations[l] >= N - l){
            return N - l;
        }
        else{
            return 0;
        }
    }
}

//TC O(logn)
//SC O(1)
//Binary search approach to find the solution
