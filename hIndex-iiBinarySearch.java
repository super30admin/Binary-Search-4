//time complexity O(log n) where n is the length of array
//space complexity O(1)

class Solution {
    int n;
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0) return 0;
        n = citations.length; int low = 0; int high = n - 1;
        while(low <= high){
            int mid = low + (high - low)/2;
            int diff = n - mid;
            if(diff == citations[mid]) return diff;
            else if(diff > citations[mid]){
                low = mid + 1;
            } else{
                high = mid - 1;
            }
        }
        return n-low;
    }
}
