// Time Complexity : O(log n) n is input length
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class hIndex {
    public int hIndex(int[] citations) {
        int start=0;
        int end = citations.length-1;
        int mid = 0;
        while(start<=end){
            mid = start + (end-start)/2;
            int diff = citations.length - mid;
            if(citations[mid]==diff)
                return diff;
            else if(citations[mid]>diff){
                end = mid-1;
            }
            else if(citations[mid]<diff){
                start = mid+1;
            }
             
        }
        return citations.length-start;
    }
}