TC : n1 + n2 
  n1 - size of nums1
  n2 - size of nums2

SC : Min(n1,n2)

class Solution {
public:
    vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
        int n1 = nums1.size();
        int n2 = nums2.size();
        if(n1 > n2)
            intersect(nums2,nums1);
        unordered_map<int,int> mp;
        vector<int> ans;
        for(int i =0 ;i< n1;++i)
            mp[nums1[i]] += 1;
        
        for(int i=0 ; i< n2 ; ++i){
            if(mp[nums2[i]]){
               mp[nums2[i]] -= 1;
                ans.emplace_back(nums2[i]);
            }
        }
        return ans;
    }
};
