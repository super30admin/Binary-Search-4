//time complexity : commented solution O(n), binary search logn
//space compleaity : O(1)
//leet code : yes
//steps: implemented using binary search

class HIndexII275 {
    public int hIndex(int[] citations) {
     
        if(citations==null||citations.length==0) return 0;
        
        int n = citations.length;
        int low = 0;
        int high = n-1;
        
        while(low<= high){
            int mid = low + (high-low)/2;
            
            int citation = citations[mid];
            int count = n-mid;
            if(citation==count) return count;
            if(citation < count){
                low = mid+1;
            }else {
                high = mid-1;
            }
        }
      /**  
        for(int i=0; i<n ; i++){
            int citation = citations[i];
            int count = n-i;
            
            if(citation>= count){
                return count;
         }
        */
            return n-low;

        }
    
}