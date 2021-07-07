// 275.

class Solution {
    public int hIndex(int[] citations) {
        //edge
        if(citations == null || citations.length == 0)
        {
            return 0;
        }
        
        //examples
        // 1. [100] -> hindex = 1; 1(h) paper with citation value >= 100 and 0(N - h) papers with citation less than 100
        // 2. [1000, 2000] -> hindex = 2(h); 2 papers with citations above 2 and 0(N - h) papers with citations less than 2
            
        //hindex = [0, citations.length]
        
        //problem reduces to finding first index at which citation value is greater than or equal to index
        //return linearApproach(citations);
        return binarySearchApproach(citations);
    }
    
    //time - O(n) with constant space
    //example
    //          ciation value                        number of papers with higher citation (N - i)
//                  (N-i) because arrays is sorted & all the papers to right have higher citation value
            //     0            <                   5  
            //     1            <                   4   
            //     3            =                   3  return 3 - first place at which >= occurs  
            //     5            >                   2
            //     6            >                   1
    private int linearApproach(int[] citations) {
        int n = citations.length;
        for(int i = 0; i < citations.length; i++)
        {
            int citationValue = citations[i];
            int numberOfPapersWithHigherCitations = n - i;
            if(citationValue >= numberOfPapersWithHigherCitations)
            {
                return numberOfPapersWithHigherCitations;
            }
        }
        return 0; //never reaches here
    }
    
    //time - O(log n) with constant space
    private int binarySearchApproach(int[] citations) {
        int low = 0;
        int high = citations.length - 1;
        int n = citations.length;
        int result = 0;
        while(low <= high)
        {
            int mid = low + (high - low) / 2;
            int citationMid = citations[mid];
            int numberOfPapersWithHigherCitations = n - mid;
            if(citationMid >= numberOfPapersWithHigherCitations)
            {
                if(citationMid == numberOfPapersWithHigherCitations)
                {
                    return numberOfPapersWithHigherCitations; //sure answer due to equality
                }
                else // > sign, cant confirm whether first occurence or not, so store and continue in left half
                {
                    result = numberOfPapersWithHigherCitations;
                    high = mid - 1;
                }
                
            }
            else //citationMid < numberOfPapersWithHigherCitations
            {
                low = mid + 1; //move to right half due to < inequality
            }
        }
        return result;
    }
}
