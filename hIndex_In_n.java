// Time Complexity : O(n) where n is the length of the citations arrays
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Find max number in array such that there exists (max - 1) elements after it in the array

class hIndex_In_n {
    public int hIndex(int[] citations) {
        if (citations.length == 0) return 0;
        int n = citations.length;
        int val = 0, numElements = 0;
        for (int i = 0; i < n; i++) {
            val = citations[i];
            numElements = n - i;
            if (val >= numElements) {
                return numElements;
            }
        }
        return 0;
    }
}