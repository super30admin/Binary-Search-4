//TC: O(n)
//SC: O(1)
class Solution {
    public int hIndex(int[] citations) {
        if(citations.length == 0) return 0;
        for(int i = 0; i < citations.length; i++){
            int diff = citations.length-i;
            if(diff <= citations[i]){
                return diff;
            }
        }
        return 0;
    }
}

//TC: O(log(n))
//SC: O(1)
class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int low = 0; int high = n - 1;
        
        while(low <= high){
            int mid = low + (high - low)/2;
            int diff = n - mid;
            if(citations[mid] == diff) return diff;
            
            if(citations[mid] < diff){
                low = mid + 1;
            }
            
            else{
                high = mid - 1;
            }
        }
        return n - low;
    }
}
