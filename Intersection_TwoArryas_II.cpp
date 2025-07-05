//Time Compelxity :O(n+m)
//Space Complexity : O(min(n,m))
#include<iostream>
#include<vector>
#include<unordered_map>
using namespace std;
class Solution {
public:
    vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
        unordered_map<int, int>mp;
        vector<int>ans;
        for(int x : nums1) 
            mp[x]++;
        for(int x : nums2) {
            if(mp[x]) {
                ans.push_back(x);
                mp[x]--;
            }
        }
        return ans;
    }
};