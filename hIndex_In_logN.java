// Time Complexity : O(lgn) where n is the length of the citations arrays
// Space Complexity : O(lgn) where n is the length of the citations arrays 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Find max number in array such that there exists (max - 1) elements after it in the array
// Finding this using binary search as the given array is already sorted

class hIndex_In_logN {
    public int hIndex(int[] citations) {
        int n = citations.length;
        if (n == 0) return 0;
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int val = citations[mid];
            int numElements = n - mid;
            if (val == numElements) return citations[mid];
            else if (val > numElements) high = mid - 1;
            else low = mid + 1;
        }
        return n - low;
    }
}