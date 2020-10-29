/*Time Complexity: O(logn)
Space Complexity: O(1)*/
class Solution {
    public int hIndex(int[] citations) {

        if(citations.length == 0 || citations == null)
        {
            return 0;
        }
        int left = 0, right = citations.length-1;
        return binarySearch(citations, left, right);
    }

    private int binarySearch(int [] citations, int left, int right)
    {
        int n = citations.length;
        while(left<=right)
        {
            int mid = left + (right-left)/2;

            if(citations[mid]<n-mid)
            {
                left = mid+1;
            }
            else
            {
                right = mid-1;
            }
        }

        return n-left;
    }
}
