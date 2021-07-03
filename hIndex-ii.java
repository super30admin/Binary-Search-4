//time complexity O(n) where n is the length of the string
//space complexity O(1)

class Solution {
    int n;
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0) return 0;
        n = citations.length;
        for(int i = 0; i < citations.length; i++){
            int diff = n - i;
            int val = citations[i];
            if(val >= diff) return diff;
        }
        return citations[0];
    }
}
