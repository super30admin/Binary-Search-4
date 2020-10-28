/*  Time : O(NLogN)
    Space : O(1)
    Leetcode : Yes
    Explanation : Find the first element such that all elements after it are greater than it. OR
                  the distance from end to current element is equal to the current element.
*/
class Solution {
public:
    int hIndex(vector<int>& citations) {
                
        int left = 0, right = citations.size() - 1;
        int n = citations.size();
        
        while(left <= right)
        {
            int mid = left + (right - left) / 2;
            if(citations[mid] == n - mid)
            {
                return n - mid;
            }
            else if(citations[mid] < n - mid)
            {
                left = mid + 1;
            }
            else
            {
                right = mid - 1;
            }
        }
        
        return n - left;
    }
};