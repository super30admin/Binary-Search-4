class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2)
    {
    
        priority_queue<int,vector<int>,greater<int>> pq;
        
        for(int i=0;i<nums1.size();i++)
        {
            pq.push(nums1[i]);
        }
        
        for(int i=0;i<nums2.size();i++)
        {
            pq.push(nums2[i]);
        }
        
        int n=pq.size();
        vector<int> answer;
        
        while(!pq.empty())
        {
            answer.push_back(pq.top());
            pq.pop();
        }
        
        if(n%2!=0)
        {
         return (double)answer[n/2];    
        }
            
        return (double)(answer[n/2]+answer[(n/2)-1])/2;
        
    }
};