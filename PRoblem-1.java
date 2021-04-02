//Time Complexity : O(logn)
//Space Complexity : O(1)

class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0) return 0;
        
        int low = 0;
        int high = citations.length-1;
        int n = citations.length;
        while(low<=high){
            int mid = low+(high-low)/2;
            int trialhindex = n-mid;
            if(citations[mid] == trialhindex) return trialhindex;
            else if(citations[mid] < trialhindex) low = mid+1;
            else high = mid-1;
        }
        return n-low;
    }
}