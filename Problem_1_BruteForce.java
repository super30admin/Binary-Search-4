// Time complexity - O(n)
// Space complexity - O(1)

// Linear Solution

class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0) return 0;
        int n = citations.length;
        for(int i = 0 ; i < citations.length; i++){
            int diff = n - i;
            if(citations[i] >= diff) return diff;
        }
        return 0;
    }
}
