// Time Complexity :  O(logn)
// Space Complexity : O(1) since it is iterative binary search.
// Did this code successfully run on Leetcode : Yes Its working
// Any problem you faced while coding this : understanding the problem iteself.
public class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length ==0 ) return 0;
        int N = citations.length;
        int l = 0;
        int h = N-1;
        while(l<=h)
        {
            int mid = (h-l)/2 +l;
            if(citations[mid]==N-mid) return N-mid;
            else if(citations[mid]<N-mid) l = mid+1;
            else h = mid-1;
        }
        
        return N-l;
    }
}