/*
    Time Complexity : O(log n)
    Space Complexity : O(1)
*/

class Solution {
    public int hIndex(int[] citations) {
        int n=citations.length;
        int low=0; int high=citations.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            int diff = n - mid;
            if(citations[mid]==diff){
                return n-mid;
            } else if(citations[mid]<diff){
                low=mid+1;
            } else {
                high=mid-1;
            }
        }
        return n-low;
    }
}

