/**
Leet Code Submitted : YES
Time Complexity : O(log(len(citations)))
Space Complexity : O(1)


The idea is to use Binary Search to find the h-index. if the mid citations is equal to the difference in citations then return value of the citations at mid location. Else, accordingly move left or right pointer till it crosses. The main issue here is to understand the problem which was not clear to me initially. 

**/
class Solution {
    public int hIndex(int[] citations) {
        
        if(citations == null || citations.length < 1)
            return 0; 
        
        return createBST(citations);
    }
    
    public int createBST(int[] citations){
        int l = 0;
        int r = citations.length - 1;
        
        int val  = 0;
        int diff = 0;
        
        while(l <= r){
            int mid = l + (r - l)/2;
            val  = citations[mid];
            diff = citations.length - mid;
            
            if(val == diff)
                return val;
            
            if(val < diff)
                l = mid + 1;
            else
                r = mid - 1;
        }
        
        return citations.length - l;
        
    }
}
