package Dec1;

class HIndex {
    public int hIndex(int[] citations) {
        
        /*
        Time complexity: O(log n) because we are using binary search.
        Space complexity: O(1) because no extra space used.
        Approach: 
        Binary search approach used to find h-index.
        We need to find the point where array element starts becoming greater than (N-element index). 
        For example:
        N = 6 (no.of elements in given array)
        Array   0         1         2         5         6         7
        N-idx   6-0=6     6-1=5     6-2=4     6-3=3     6-4=2     6-5=1
                0 < 6     1 < 5     2 < 4     5 > 3     6 > 2     7 > 1                                                             /\
                                                |
                                                |
                                                |
        Output: H index is 3, i.e.(N-crossing array element index)
        
        NOTE: 
        Wherever diff is becoming = to number of citations or crossing the number of citations, find that position.
        */
        
        // edge
        if (citations == null || citations.length == 0) {
            return 0;
        }
        
        int n = citations.length;
        int low = 0;
        int high = n-1;
        
        // binary search 
        while (low <= high) {
            int mid = low + (high-low)/2;
            // refer above example, so to find crossing point, we need to increase citations[mid]. Since it is a sorted array, we need to move towards right
            if (citations[mid] < n-mid) {
                low = mid + 1;
            }
             // refer above example, so to find crossing point, we need to reduce citations[mid]. Since it is a sorted array, we need to move towards left.
            else if (citations[mid] > n - mid) {
                high = mid - 1;
            } 
            // if equal, we have found the h-index point, return the value
            else {
                return n-mid;
            }
        }
        
        return n-low;
    }
}
