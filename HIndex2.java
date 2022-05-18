//TC : O(Log n)
//SC : O(1)
class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int low = 0;
        int high = citations.length-1;

        while(high >= low)
        {
            int mid = low +(high-low)/2;
            int h = n-mid;
            if(citations[mid] == h)
                return h;
            else if(citations[mid] < h)
                low = mid+1;
            else
                high = mid-1;
        }
        return n-low;
    }
}