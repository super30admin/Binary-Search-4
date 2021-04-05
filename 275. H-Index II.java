class Solution {// time of O(lg n) and space of O(1)
    public int hIndex(int[] citations) {
        int n = citations.length ;
        int left = 0 ;
        int right = n-1;
        int mid ;
        
        while(left <= right ){
            mid = left + (right - left)/2 ;
            if(citations[mid] == n- mid )
                return n- mid ;
            else if (citations[mid] < n-mid) left = mid + 1 ;
            else right = mid -1 ;
        }
        return n-left ;
        
    }
}