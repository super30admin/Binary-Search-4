// Time Complexity : O(log(n)) --> where n is the length of the input array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode (275): Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int hIndex(int[] citations) {
        // edge case
        if (citations == null || citations.length == 0) return 0;
        
        int low = 0;
        int high = citations.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) / 2);
            int diff = citations.length - mid;
            if (citations[mid] ==  diff) return diff;
            else if (diff > citations[mid]) low = mid + 1;
            else high = mid - 1;
        }
        return citations.length - low;
    }
}