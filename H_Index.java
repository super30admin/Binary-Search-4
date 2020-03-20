class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length ==0)
            return 0;
       
        int n  = citations.length;
        //Binary Search Solution
        int low = 0;  // Start from 0
        int high = n-1; // till last number
        
            while(low <= high){    // We need to validate untill high crosses low so it should be '<='
                int mid = low + (high - low)/2;
                int citation = citations[mid];
                int noOfCitationAfterMid = n-mid;
                if(noOfCitationAfterMid == citation) return noOfCitationAfterMid;
                // noOfCitationAfterMid is the count of citations available after mid element.
                
                if(noOfCitationAfterMid > citation){   
                    low = mid+1;
                }else{
                    high = mid-1;
                }
                
            }
        return n-low;
        // Iterative Solution
//         int n = citations.length;
//         int citation = 0;
//         int count = 0; 
//         for(int i=0;i<n;i++){
//             citation = citations[i];
//             count = n-i;
//             // System.out.println(citation +"  " + count);
//             if(count == citation) 
//                 return count;
            
//             if(count < citation)
//                 return count;
//         }
//         return 0;
        
    }
}
