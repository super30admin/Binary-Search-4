// Time Complexity : O(m+n)

// Space Complexity : O(min(m,n) - hashmap

// Did this code successfully run on Leetcode : YES

// Appoarch: Using hashmap, to store freq's and linear search across second
// array to find the intersection values.


#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
        map<int,int> mp;
        vector<int> ans;
        if(nums2.size() > nums1.size()){
            return intersect(nums2,nums1);
        }
        for(int i=0;i<nums1.size();i++){
            mp[nums1[i]]++;
        }
        for(int i=0;i<nums2.size();i++){
            if(mp[nums2[i]] > 0){
                ans.push_back(nums2[i]);
                mp[nums2[i]]--;
            }
        }
        return ans;
    }
};