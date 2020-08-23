class Solution {
    public int hIndex(int[] citations) {
        if(citations.length == 0) return 0;
        for(int i = 0; i < citations.length; i++){
            int diff = citations.length-i;
            if(diff <= citations[i]){
                return diff;
            }
        }
        return 0;
    }
}
