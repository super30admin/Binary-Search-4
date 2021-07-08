// Time Complexity : O((m+n)*log(m+n))
// Space Complexity :  O(m+n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this

class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        
        priority_queue<int, vector<int>, greater<int>> pq;
        int i;
        
        for(i = 0; i < nums1.size(); i++)
            pq.push(nums1[i]);
        
        for(i = 0; i < nums2.size(); i++)
            pq.push(nums2[i]);
        
        vector<int> vect;
        
        while(!pq.empty())
        {
            vect.push_back(pq.top());
            pq.pop();
        }
        
        double ret_val = 0;
        
        if(vect.size() % 2 == 1)
        {
            // odd
            ret_val = vect[vect.size() / 2];
        }
        else
        {
            // even
            int len = vect.size();
            double n1 = double(vect[len/2]);
            double n2 = double(vect[(len/2)-1]);
            ret_val = (n1 + n2)/2;
        }
        
        return ret_val;
    }
};