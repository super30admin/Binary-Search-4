
//Time Complexity O(n)
// Space Complexity O(n)
//Problem successfully executed on leetcode
//No problems faced while coading this.


#include<iostream>
#include<vector>
#include<queue>
#include<map>
#include<stack>
using namespace std;



class Solution {
public:
    vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
        if(nums2.size()>nums1.size())
        {
            return intersect(nums2,nums1);
        }
        
        map<int,int> mp;
        
        for(auto &num : nums1)
        {
            if(mp.find(num)==mp.end())
            {
                mp[num]=0;
            }
            mp[num]++;
        }
        
        vector<int> result;
        
        for(auto &num : nums2)
        {
            if(mp.find(num)!=mp.end())
            {
                result.push_back(num);
                mp[num]--;
            }
            if(mp[num]==0)
            {
                mp.erase(num);
            }
        }
        return result;
    }
};