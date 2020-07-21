//Time Complexity : O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No
class Solution {
public:
    //Binary search solution
    int hIndex(vector<int>& citations) {
        int n = citations.size();
        int low = 0; int high = n-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            
            if(citations[mid]==(n-mid))
                return n-mid;
            
            else if(citations[mid]>(n-mid))
                high = mid -1;
            
            else
                low = mid+1;
        }
        
        return n-low;
    }
};