// Time Complexity: O(N) best case, O(logN) worst case
// Space Complexity: O(1)

class Solution {
    public int hIndex(int[] citations) {

        //base case
        if(citations == null || citations.length == 0)
             return 0;

        int n=citations.length;
        int low=0, high=n-1;

        while(low <= high)
        {
            int mid = low+(high-low)/2;
            if(citations[mid] == n-mid)
                return n-mid;

            if(citations[mid] < n-mid)
                low=mid+1;
            else
                high=mid-1;
        }

        return n-low;
    }
}