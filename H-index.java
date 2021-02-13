/*
TC : O(log n), where n is no of papers
SC : O(1)

Approach:
A bruteforce could be to find the first index where citations[i] >= n-i, then return n-i;
Optimization could be to find index using binary search
*/ 
class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int left = 0;
        int right = n-1;
        
        while(left<=right){
            int mid = left + (right-left)/2;
            
            if(n-mid == citations[mid]){
                return citations[mid];
            }
            else if(n-mid < citations[mid]){
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }
        
        return n-left;
    }
}