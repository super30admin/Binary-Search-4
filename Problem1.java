// O(n) time

class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) return 0;
      //  Arrays.sort(citations); // if array is not sorted.
        int len = citations.length;
        for (int i = 0; i < citations.length; i++) {
            if (len <= citations[i])
                return len;
            else
                len--;
        }
        return len;
    }
}
