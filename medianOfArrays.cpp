// Two heap solution
// Time Complexity : O(mlogm + nlogn); 
// Space Complexity : O(m+n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// 1. Maintain a max-heap of all smaller elements and a min-heap of all larger elements. The max is allowed one element more than the min-heap
// 2. Add both arrays to the heap such keeping the heaps balanced as per above conditions
// 3. At the end return top of max-heap or mean of top of both heaps depending on their sizes   

class Solution {
public:
    void addToHeap(priority_queue<int>& small, priority_queue<int, vector<int>, greater<int>>& large, vector<int>& nums){
        // small heap can have at the most 1 element more than high 
        for(auto el: nums){
            // cout<<"adding "<<el<<endl; 
            small.push(el);
            if(small.size() == large.size()+2){
                large.push(small.top()); small.pop();
            }
            else if(large.size()!=0 && small.size()>large.size() && small.top()>large.top()){
                int temp1 = small.top(); small.pop();
                int temp2 = large.top(); large.pop();
                large.push(temp1);
                small.push(temp2);
            }
        }
    }
    
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        priority_queue<int> small; // max heap
        priority_queue<int, vector<int>, greater<int>> large; // min heap
        addToHeap(small, large, nums1);
        addToHeap(small, large, nums2);
        if(small.size()>large.size())
            return (double)small.top();
        else
            return (double)(small.top()+large.top())/2;
    }
};