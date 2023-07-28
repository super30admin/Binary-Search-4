class Solution {
public:
    vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
        unordered_map<int,int> mp; 
        vector<int> result; 

        for(int i = 0; i < nums2.size(); i++) {
            mp[nums2[i]]++;
        }    

        for(int i = 0; i < nums1.size(); i++) {
            if(mp[nums1[i]] != 0) {
                result.push_back(nums1[i]);
                mp[nums1[i]]--; 
            }
        }
        
        return result; 
    }
};