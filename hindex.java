//Time Complexity: o(n)
//Space Complexity: o(1)


// class Solution {
//     public int hIndex(int[] citations) {
        
//     if(citations.length == 0) return 0;
        
//     int n = citations.length;
        
//     for(int i = 0; i < citations.length; i++){
//         if(citations[i] >= n - i){
//             return n - i;
//         }
//     }
        
//        return 0; 
//     }
// }


class Solution {
    public int hIndex(int[] citations) {
        
    if(citations.length == 0) return 0;
        
    int n = citations.length;
        
    int low = 0;
    int high = n-1;
        
    while(low <= high){
        int mid = low + (high - low)/2;
        if(citations[mid] >= n - mid)
        {
            high = mid - 1;
        }
        else{
            low = mid + 1;
        }
    }
        
       return n - low; 
    }
}