class Solution {
    public int hIndex(int[] citations) {
        
        if (citations == null || citations.length == 0){
            return 0;
        }
        
        int n = citations.length;
        
        for (int i = 0; i < n; i++){
            int citation = citations[i];
            
            if (citation >= n-i){
                return n-i;
            }
        }
        
        return 0;
            
        
    }
}