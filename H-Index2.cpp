// Approach 1 - Simple linear iteration.
// Time Complexity - O(n), n - number of elements in the citations vector.
// Space Complexity - O(1)
class Solution {
public:
    int hIndex(vector<int>& citations) {
        int n = citations.size();
        for(int i = 0; i < n; i++){
            int diff = n - i;
            if(diff <= citations[i])
                return diff;
        }
        return 0;
    }
};

// Approach 2 - Binary Search - Finding the difference at the index when it becomes equal to or greater than the number of citations at that index.
// Time Complexity - O(log n), n - number of elements in the citations vector.
// Space Complexity - O(1)

class Solution {
public:
    int hIndex(vector<int>& citations) {
        int n = citations.size();
        int low = 0;
        int high = n-1;
        int mid;
        
        while(low <= high){
            int mid = low + (high - low)/2;
            int diff = n - mid;
            if(citations[mid] == diff)
                return citations[mid];
            else if(citations[mid] > diff)
                high = mid - 1;
            else
                low = mid + 1;
        }
        
        return n - low;
    }
};